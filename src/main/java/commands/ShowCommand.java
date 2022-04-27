package commands;

import Client.Vehicles;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        vehicles.getCollection_manager().show();
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescribe() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }



    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new ShowCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}
