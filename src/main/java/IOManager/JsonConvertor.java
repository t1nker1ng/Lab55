package IOManager;

import Collec.*;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class JsonConvertor {
    static public String toJson(HashMap<Long, Car> collection) {
        Gson gson = new Gson();
        return gson.toJson(collection);
    }

    static public HashMap<Long, Car> fromJson(String json) {
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<Long, Car>>() {
            }.getType();
            return gson.fromJson(json, type);
        } catch (JsonSyntaxException ex) {
            return null;
        }
    }
}
