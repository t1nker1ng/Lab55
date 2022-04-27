package commands;

import Client.Vehicles;
import Collec.Car;
import IOManager.*;

import java.util.HashMap;

public class UpdateIdCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        CarGetter carGetter = new CarGetter(vehicles.getIn(), vehicles.getOut(), !vehicles.isScript());
        Car o = carGetter.readCarGetter();
        long key = o.getId();
        vehicles.getCollection_manager().update_id(o, key);
    }

    @Override
    public String getName() {
        return "update_id";
    }

    @Override
    public String getDescribe() {
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }


    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new UpdateIdCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}