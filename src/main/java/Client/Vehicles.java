package Client;

import commands.Command;
import Collec.*;
import IOManager.*;

import java.util.HashMap;

public class Vehicles {
    private final Collection_manager collection_manager;
    private final HashMap<String, Command> commandMap;
    private boolean isRunning;
    private final ReadAbility in;
    private final WriteAbility out;
    private final String path;
    private final boolean script;

    public Vehicles(Collection_manager collection_manager, HashMap<String, Command> commandMap, String path, ReadAbility in, WriteAbility out, boolean isScript) {
        this.collection_manager = collection_manager;
        this.commandMap = commandMap;
        this.path = path;
        this.in = in;
        this.out = out;
        isRunning = true;
        this.script = isScript;
    }

    public ReadAbility getIn(){
        return in;
    }

    public WriteAbility getOut(){
        return out;
    }

    public Collection_manager getCollection_manager() {
        return collection_manager;
    }

    public HashMap<String, Command> getCommandMap() {
        return commandMap;
    }


    public String getPath(){
        return path;
    }

    public boolean IsRunning() {
        return isRunning;
    }

    public boolean isScript(){
        return script;
    }

    public void turnOff() {
        isRunning = false;
    }
}
