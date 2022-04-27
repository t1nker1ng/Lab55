package commands;

import Client.Vehicles;
import Collec.Car;
import IOManager.*;

import java.util.HashMap;

public class InsertNullCommand implements Command {

    @Override
    public String getName() {
        return "insert_null";
    }

    @Override
    public String getDescribe() {
        return "insert null {element} : добавить новый элемент с заданным ключом";
    }



    @Override
    public void execute(Vehicles vehicles, String args) {
        CarGetter carGetter = new CarGetter(vehicles.getIn(), vehicles.getOut(), !vehicles.isScript());
        Car o = carGetter.readCarGetter();
        long key = o.getId();
        vehicles.getCollection_manager().insert_null(o, key);
    }



    public static void register(HashMap<String, Command> commandMap) {
        Command cmd = new InsertNullCommand();
        commandMap.put(cmd.getName(), cmd);
    }
}
