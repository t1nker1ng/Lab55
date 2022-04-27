package commands;

import Client.Vehicles;

import java.util.HashMap;

public class MinByCoordinatesCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        vehicles.getCollection_manager().min_by_coordinates();
    }

    @Override
    public String getName() {
        return "min_by_coordinates";
    }

    @Override
    public String getDescribe() {
        return "min_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является минимальным";
    }


    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new MinByCoordinatesCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}
