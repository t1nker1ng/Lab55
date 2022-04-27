package commands;

import Client.Vehicles;

import java.util.HashMap;

public class ClearCommand implements Command {

    @Override
    public void execute(Vehicles vehicles, String args) {
        vehicles.getCollection_manager().clear();
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescribe() {
        return "clear : очистить коллекцию";
    }


    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new ClearCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}