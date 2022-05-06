package Collec;

import java.util.Date;

public class Car implements Comparable<Car> {
    private static long idOrder = 0;
    private final long id;
    private final String name;
    private final Coordinates coordinates;
    private final VehicleType type;
    private final FuelType fuelType;
    private final Integer enginePower;
    private final java.util.Date creationDate;

    public Car(String name, Coordinates coordinates, Integer enginePower, Date creationDate, VehicleType type, FuelType fuelType) {
        this.id = ++idOrder;
        this.name = name;
        this.coordinates = coordinates;
        this.enginePower = enginePower;
        this.creationDate = creationDate;
        this.type = type;
        this.fuelType = fuelType;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return ("id =" + this.id + "\n" +
                "name = " + this.name + "\n" +
                this.coordinates.toString() + "\n" +
                "enginePower = " + this.enginePower + "\n" +
                "VehicleType = " + this.type + "\n" +
                "FuelType = " + this.fuelType
        );
    }

    @Override
    public int compareTo(Car o) {
        if (o == null) {
            return 1;
        }
        int result = this.name.compareTo(o.name);
        if (result == 0) {
            result = this.enginePower.compareTo(o.enginePower);
        }
        if (result == 0) {
            result = this.coordinates.compareTo(o.coordinates);
        }
        if (result == 0) {
            result = this.creationDate.compareTo(o.creationDate);
        }
        return result;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }


    public VehicleType getType() {
        return type;
    }

}