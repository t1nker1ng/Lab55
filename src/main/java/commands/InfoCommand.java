package commands;

import Client.Vehicles;

import java.util.HashMap;

public class InfoCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        vehicles.getCollection_manager().info();
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescribe() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }


    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new InfoCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}