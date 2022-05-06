package Main;

import Client.*;
import commands.*;
import Collec.Collection_manager;
import IOManager.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String path = "collection.json";
        ReadAbility in = ConsoleManager.getInstance();
        WriteAbility out = ConsoleManager.getInstance();
        Collection_manager myCollection = new Collection_manager(in, out);
        HashMap<String, Command> commandMap = new HashMap<String, Command>();

        ClearCommand.register(commandMap);
        ExitCommand.register(commandMap);
        HelpCommand.register(commandMap);
        InfoCommand.register(commandMap);
        InsertNullCommand.register(commandMap);
        MinByCoordinatesCommand.register(commandMap);
        PrintDescendingCommand.register(commandMap);
        RemoveAnyByTypeCommand.register(commandMap);
        RemoveKeyNullCommand.register(commandMap);
        ReplaceIfGreaterNullCommand.register(commandMap);
        ReplaceIfLoweNullCommand.register(commandMap);
        SaveCommand.register(commandMap);
        ShowCommand.register(commandMap);
        UpdateIdCommand.register(commandMap);

        File file = new File(path);
        if (file.isFile()) {
            if (file.length() > 0) {
                myCollection.load(path);
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("File can't be created\\nFinishing of working program");
                ex.printStackTrace();
                System.exit(1);
            }
        }
        Vehicles vehicles = new Vehicles(myCollection, commandMap, path, in, out, false);
        Client client = new Client(vehicles);
        client.init();
    }
}
