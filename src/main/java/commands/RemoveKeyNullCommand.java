package commands;

import Client.Vehicles;

import java.util.HashMap;

public class RemoveKeyNullCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        long key = 0;
        if (!args.isEmpty()){
            try{
                key = Long.parseLong(args);
            } catch (Exception ex){
                vehicles.getOut().writeln("Неверно введен ключ");
            }
            vehicles.getCollection_manager().remove_key(key);
        }
        else{
            vehicles.getOut().writeln("Вы ввели не ключ");
        }
    }

    @Override
    public String getName() {
        return "remove_key_null";
    }

    @Override
    public String getDescribe() {
        return "remove_key null : удалить элемент из коллекции по его ключу";
    }



    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new RemoveKeyNullCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}