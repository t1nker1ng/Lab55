package commands;

import Client.Vehicles;
import Collec.Car;
import Collec.VehicleType;
import IOManager.CarGetter;

import java.util.HashMap;

public class RemoveAnyByTypeCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        CarGetter carGetter = new CarGetter(vehicles.getIn(), vehicles.getOut(), !vehicles.isScript());
        Car o = carGetter.readCarGetter();
        VehicleType type = o.getType();
        vehicles.getCollection_manager().remove_any_by_type(o, type);
    }

    @Override
    public String getName() {
        return "remove_any_by_type";
    }


    @Override
    public String getDescribe() {
        return "remove_any_by_type type : удалить из коллекции один элемент, значение поля type которого эквивалентно заданному";
    }

    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new RemoveAnyByTypeCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}
