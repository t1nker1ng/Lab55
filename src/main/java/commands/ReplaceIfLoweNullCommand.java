package commands;

import Client.Vehicles;
import Collec.Car;
import IOManager.CarGetter;

import java.util.HashMap;

public class ReplaceIfLoweNullCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        CarGetter carGetter = new CarGetter(vehicles.getIn(), vehicles.getOut(), !vehicles.isScript());
        Car o = carGetter.readCarGetter();
        long key = o.getId();
        vehicles.getCollection_manager().replace_if_lowe(o, key);
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
