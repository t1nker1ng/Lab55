package commands;

import Client.Vehicles;

public interface Command {
    void execute(Vehicles vehicles, String args);

    String getName();

    String getDescribe();
}
