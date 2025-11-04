package by.dulskij.taskarray.warehouse;

import by.dulskij.taskarray.entity.CustomArrayParameters;

import java.util.HashMap;
import java.util.Map;

public class CustomArrayWarehouse {
    private static CustomArrayWarehouse instance;

    private HashMap<Integer, CustomArrayParameters> customArrayParameters = new HashMap<>();

    private CustomArrayWarehouse() {}

    public static CustomArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new CustomArrayWarehouse();
        }
        return instance;
    }

    public Map<Integer, CustomArrayParameters> getCustomArrayParameters() {
        return Map.copyOf(customArrayParameters);
    }
    public CustomArrayParameters put(Integer key, CustomArrayParameters value) {
        return customArrayParameters.put(key, value);
    }
}
