package commands;

import Client.Vehicles;
import Collec.*;
import IOManager.*;

import java.util.HashMap;

public class ReplaceIfGreaterNullCommand implements Command {

    @Override
    public void execute(Vehicles vehicles, String args) {
        long id = 0;
        if (!args.isEmpty()) {
            try {
                id = Long.parseLong(args);
            } catch (Exception ex) {
                vehicles.getOut().writeln("Wrong arg");
                return;
            }
            CarGetter carGetter = new CarGetter(vehicles.getIn(), vehicles.getOut(), !vehicles.isScript());
            Car o = carGetter.readCarGetter();
            vehicles.getCollection_manager().replace_if_greater(o, id);
        } else {
            vehicles.getOut().writeln("Arg is missing");
        }
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
