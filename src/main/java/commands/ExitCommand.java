package commands;

import Client.Vehicles;

import java.util.HashMap;

public class ExitCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        vehicles.getOut().writeln("Goodbye!");
        vehicles.turnOff();
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescribe() {
        return "exit : завершить программу (без сохранения в файл)";
    }


    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new ExitCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}
