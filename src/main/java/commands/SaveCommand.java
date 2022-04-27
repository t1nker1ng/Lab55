package commands;

import Client.Vehicles;

import java.util.HashMap;

public class SaveCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        vehicles.getCollection_manager().save(vehicles.getPath());
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescribe() {
        return "save : сохранить коллекцию в файл";
    }



    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new SaveCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}
