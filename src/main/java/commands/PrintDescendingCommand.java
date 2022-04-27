package commands;

import Client.Vehicles;

import java.util.HashMap;

public class PrintDescendingCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        vehicles.getCollection_manager().print_descending();
    }

    @Override
    public String getName() {
        return "print_descending";
    }

    @Override
    public String getDescribe() {
        return "print_descending : вывести элементы коллекции в порядке убывания";
    }



    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new PrintDescendingCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}
