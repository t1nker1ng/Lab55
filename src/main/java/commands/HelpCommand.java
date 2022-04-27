package commands;

import Client.Vehicles;

import java.util.HashMap;

public class HelpCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        for (Command cmd : vehicles.getCommandMap().values()) {
            vehicles.getOut().writeln(cmd.getDescribe());
        }
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescribe() {
        return "help : вывести справку по доступным командам";
    }


    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new HelpCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}
