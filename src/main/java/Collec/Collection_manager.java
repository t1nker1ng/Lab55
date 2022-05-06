package Collec;

import IOManager.*;
import java.io.IOException;

import java.util.Date;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;


public class Collection_manager {
    private HashMap<Long, Car> Collection;
    private final Date date;
    private ReadAbility in;
    private WriteAbility out;
    private Car vehicle;

    public Collection_manager(ReadAbility in, WriteAbility out) {
        Collection = new HashMap<Long, Car>();
        date = new java.util.Date();
        this.in=in;
        this.out=out;
    }

    public void info() {
        out.writeln("Type: " + Collection.getClass().toString());
        out.writeln("Date of initialization: " + date.toString());
        out.writeln("Amount of elements: " + Collection.size());
    }

    public void show() {
        out.writeln("-------------------------");
        out.writeln(Collection.toString());
        out.writeln("-------------------------");
    }

    public void insert_null(Car o, long key) {
        Collection.put(key, o);
    }

    public void update_id(Car o, long id) {
        for (HashMap.Entry<Long, Car> entry : Collection.entrySet()) {
            if (id == entry.getValue().getId()) {
                Collection.remove(id);
                Collection.put(id, o);
            }
        }
    }

    public void remove_key(long key) {
        Collection.remove(key);
    }

    public void clear() {
        Collection.clear();
    }

    public void save(String path){
        try{
            WriteAbility fileWriter = new WritingFile(path);
            fileWriter.write(JsonConvertor.toJson(Collection));
        }
        catch (IOException e){
            out.writeln("Ошибка сохранения");
        }
    }

    public void replace_if_greater(Car o, long key) {
        if (Collection.get(key).compareTo(o) >= 0){
            Collection.replace(key,o);
        }
    }

    public void replace_if_lowe(Car o, long key) {
        if (Collection.get(key).compareTo(o) <= 0){
            Collection.replace(key,o);
        }
    }

    public void min_by_coordinates() {
        for (HashMap.Entry<Long, Car> entry : Collection.entrySet()) {
            if (entry.getValue().getCoordinates().compareTo(vehicle.getCoordinates()) < 0) {
                vehicle = entry.getValue();
            }
        }
        if (vehicle != null)
            System.out.println(vehicle);
        else
            System.out.println("Коллекция пуста");
    }

    public void remove_any_by_type(VehicleType type) {
        for (HashMap.Entry<Long, Car> entry : Collection.entrySet()) {
            if (entry.getValue().getType().compareTo(type) == 0) {
                Collection.remove(entry.getKey());
            }
        }
    }

    public void print_descending() {
        Map<Long, Car> sorted = Collection
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new)
                );
        sorted = Collection
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new)
                );
        sorted = Collection
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new)
                );
        System.out.println(sorted);
    }

    public void load(String path){
        ReadAbility fileReader;
        try {
            fileReader = new File_Reader(path);
        } catch (IOException e) {
            out.writeln("Файл коллекции не найден или недоступен");
            return;
        }
        String collectionJson = "";
        String sTemp;
        while ((sTemp = fileReader.readline())!=null)
            collectionJson+=sTemp;
        Collection = JsonConvertor.fromJson(collectionJson);
        if (Collection == null){
            out.writeln("Файл поврежден");
            Collection = new HashMap<Long, Car>();
            out.writeln("Cоздана пустая коллекция");
            return;
        }
        out.writeln("Коллекция была загружена из файла "+path);
        long id=0;
        for (Car car : Collection.values()) {
            if (car.getId() > id)
                id = car.getId();
        }
    }
}
