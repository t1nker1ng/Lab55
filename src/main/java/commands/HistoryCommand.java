package commands;

import Client.*;

import java.util.ArrayList;
import java.util.HashMap;

public class HistoryCommand implements Command {
    public static ArrayList<String> historyArr = new ArrayList<>();

    @Override
    public void execute(Vehicles vehicles, String args) {
        StringBuilder history = new StringBuilder();
        for (int i = historyArr.size(); i - 10 < i; i++) {
            history.append(historyArr.get(i)).append("\n");
        }
        vehicles.getOut().writeln(history.toString());
    }

    @Override
    public String getName() {
        return "history";
    }

    @Override
    public String getDescribe() {
        return "history : вывести последние 10 команд (без их аргументов)";
    }

    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new HistoryCommand();
        commandMap.put(cmd.getName(), cmd);
    }

}
