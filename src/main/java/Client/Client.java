package Client;

public class Client {
    private final Vehicles vehicles;


    public Client(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    public void init() {
        while (vehicles.IsRunning()) {
            String s = vehicles.getIn().readline();

            if (s == null)
                if (vehicles.isScript())
                    break;
                else
                    continue;

            String cmd = "";
            String arg = "";

            String[] Arr = s.split("\\s");
            if (Arr.length == 1)
                cmd = Arr[0];
            if (Arr.length > 1) {
                cmd = Arr[0];
                arg = Arr[1];
            }

            if (vehicles.getCommandMap().containsKey(cmd)) {
                vehicles.getCommandMap().get(cmd).execute(vehicles, arg);
            } else {
                vehicles.getOut().writeln("Command not found");
            }
        }
    }

}
