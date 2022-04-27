package commands;

import Client.Client;
import Client.Vehicles;
import IOManager.File_Reader;
import IOManager.ReadAbility;
import IOManager.EmptyOut;

import java.io.IOException;
import java.util.HashMap;

public class ExecuteScriptCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        if (!args.isEmpty()){
            ReadAbility readerFile;
            try {
                readerFile = new File_Reader(args);
            } catch (IOException ex){
                System.err.println("Файл скрипта не может быть прочитан");
                return;
            }
            Vehicles vehScript = new Vehicles(
                    vehicles.getCollection_manager(),
                    vehicles.getCommandMap(),
                    vehicles.getPath(),
                    readerFile,
                    new EmptyOut(),
                    true
            );
            Client clientScript = new Client(vehScript);
            try{clientScript.init();}
            catch (Exception ex){
                vehicles.getOut().writeln("Ошибка во время выполнение скрипта");
            }
            vehicles.getOut().writeln("Чтение скрипта завершено");
        }
        else {
            System.err.println("Документ должен содержать путь к файлу");
        }
    }

    @Override
    public String getName() {
        return "Execute_Script";
    }

    @Override
    public String getDescribe() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }


    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new ExecuteScriptCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}
