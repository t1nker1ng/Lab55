package commands;

import Client.Vehicles;
import Collec.*;
import IOManager.*;

import java.util.HashMap;

public class ReplaceIfGreaterNullCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        CarGetter carGetter = new CarGetter(vehicles.getIn(), vehicles.getOut(), !vehicles.isScript());
        Car o = carGetter.readCarGetter();
        long key = o.getId();
        vehicles.getCollection_manager().replace_if_greater(o, key);
    }

    @Override
    public String getName() {
        return "replace_if_greater";
    }

    @Override
    public String getDescribe() {
        return "replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого";
    }



    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new ReplaceIfGreaterNullCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}
