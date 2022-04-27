package IOManager;

import Collec.*;
import jdk.jfr.Experimental;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

public class CarGetter {
    private final ReadAbility in;
    private WriteAbility out;
    private boolean interactive;

    public CarGetter(ReadAbility in, WriteAbility out, boolean interactive){
        this.in = in;
        this.out = out;
        this.interactive = interactive;
    }

    private interface Condition<T>{
        boolean check(T o);
    }

    private interface Expression<T>{
        T exec();
    }
    private String readStr(){
        return in.readline();
    }
    private Integer readInt(){
        try{
            return Integer.parseInt(in.readline());
        }
        catch (NumberFormatException ex){
            return null;
        }
    }
    private Float readFloat(){
        try{
            return Float.parseFloat(in.readline());
        }
        catch (NumberFormatException ex){
            return null;
        }
    }
    private Long readLong(){
        try{
            return Long.parseLong(in.readline());
        }
        catch(NumberFormatException ex){
            return null;
        }
    }

    private <T> T readArg(String message, Expression<T> query){
        if(interactive)
            out.write(message);
        return query.exec();
    }
    private <T> T readArgWhile(String message, String hint, Condition<T> condition, Expression<T> query){
        if (interactive)
            out.writeln(message);
        T o =  readArg(">>>",query);
        while (interactive && !condition.check(o)) {
            if (interactive)
                out.writeln(hint);
            o = readArg(">>>", query);
        }
        return o;
    }

    private String readName(){
        return (String)readArgWhile("Введите название транспорта", "Название не может быть пустым",
        (s) -> s!=null && !s.isEmpty(), this::readStr);
    }

    private Coordinates readCoords(){
        Float x = (Float)readArgWhile("Введите координаты транспорта по X", "Значение должно быть действительным числом",
                Objects::nonNull, this::readFloat);
        Float y = (Float)readArgWhile("Введите координаты транспорта по Y", "Значение должно быть действительным числом",
                Objects::nonNull, this::readFloat);
        return new Coordinates(x,y);
    }

    private int readEnginePower(){
        return (Integer)readArgWhile("Введите Engine Power", "Значение должно быть целым",
                (s) -> s!=null && s>0, this::readInt);
    }

    private VehicleType readVehicleType(){
        String typeStr = (String)readArgWhile("Введите тип транспорта", "Значение должно быть одним из: "+ VehicleType.enumToStr(),
                (s) -> s!=null && (s.isEmpty() || VehicleType.isType(s)), this::readStr);
        VehicleType vehicleType;
        if (typeStr.isEmpty())
            vehicleType = null;
        else
            vehicleType = VehicleType.valueOf(typeStr);
        return vehicleType;
    }

    private FuelType readFuelType(){
        String fueltypeStr = (String)readArgWhile("Введите тип бензина", "Значение должно быть одним из: "+ FuelType.enumToStr(),
                (s) -> s!=null && (s.isEmpty() || FuelType.isFuelType(s)), this::readStr);
        FuelType fuelType;
        if (fueltypeStr.isEmpty())
            fuelType = null;
        else
            fuelType = FuelType.valueOf(fueltypeStr);
        return fuelType;
    }

    public Car readCarGetter(){
        return new Car(readName(), readCoords(),
                readEnginePower(), new Date(),
                readVehicleType(), readFuelType());
    }

}
