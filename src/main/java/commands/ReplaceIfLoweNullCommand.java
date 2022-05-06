package commands;

import Client.Vehicles;
import Collec.Car;
import IOManager.CarGetter;

import java.util.HashMap;

public class ReplaceIfLoweNullCommand implements Command {
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
            vehicles.getCollection_manager().replace_if_lowe(o, id);
        } else {
            vehicles.getOut().writeln("Arg is missing");
        }
    }

    @Override
    public String getName() {
        return "replace_if_lower";
    }

    @Override
    public String getDescribe() {
        return "replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого";
    }


    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new ReplaceIfLoweNullCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}
