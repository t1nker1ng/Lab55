package commands;

import Client.Vehicles;
import Collec.Car;
import IOManager.*;

import java.util.HashMap;

public class UpdateIdCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        long id = 0;
        if (!args.isEmpty())
            try{
                id = Long.parseLong(args);
            }
            catch (Exception ex){
                vehicles.getOut().writeln("Wrong arg");
            }
        else{
            System.err.println("Wront arg");
            return;
        }
        CarGetter carGetter = new CarGetter(vehicles.getIn(), vehicles.getOut(), !vehicles.isScript());
        Car o = carGetter.readCarGetter();
        vehicles.getCollection_manager().update_id(o, id);
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