package commands;

import Client.Vehicles;
import Collec.VehicleType;

import java.util.HashMap;

public class RemoveAnyByTypeCommand implements Command {
    @Override
    public void execute(Vehicles vehicles, String args) {
        String[] types = new String[3];
        types[0] = "CHOPPER";
        types[1] = "PLANE";
        types[2] = "HOVERBOARD";
        if (!args.isEmpty()) {
            if (args.equals(types[0])) {
                vehicles.getCollection_manager().remove_any_by_type(VehicleType.CHOPPER);
            }
            if (args.equals(types[1])) {
                vehicles.getCollection_manager().remove_any_by_type(VehicleType.PLANE);
            }
            if (args.equals(types[2])) {
                vehicles.getCollection_manager().remove_any_by_type(VehicleType.HOVERBOARD);
            } else {
                vehicles.getOut().writeln("Вы ввели неверный type");
            }
        } else {
            vehicles.getOut().writeln("Вы ввели не type");
        }
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
