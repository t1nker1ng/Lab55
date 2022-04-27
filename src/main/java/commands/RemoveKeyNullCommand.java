package commands;

import Client.Vehicles;
import Collec.Car;
import Collec.VehicleType;
import IOManager.*;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveKeyNullCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        CarGetter carGetter = new CarGetter(vehicles.getIn(), vehicles.getOut(), !vehicles.isScript());
        Car o = carGetter.readCarGetter();
        long key = o.getId();
        vehicles.getCollection_manager().remove_key(key);
    }

    @Override
    public String getName() {
        return "remove_key_null";
    }

    @Override
    public String getDescribe() {
        return "remove_key null : удалить элемент из коллекции по его ключу";
    }



    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new RemoveKeyNullCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}