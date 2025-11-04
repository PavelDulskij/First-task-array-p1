package by.dulskij.taskarray.repository;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomArrayRepository {
    List<CustomArray> arrays = new ArrayList<>();
    private static CustomArrayRepository instance;

    private CustomArrayRepository() {}

    public static CustomArrayRepository getInstance() {
        if (instance == null) {
            instance = new CustomArrayRepository();
        }
        return instance;
    }

    public void addArray (CustomArray array) { arrays.add(array); }

    public void removeArray (CustomArray array) { arrays.remove(array); }

    public void sortArray(Comparator<? super CustomArray> comparator) {
        arrays.sort(comparator);
    }

    public List<CustomArray> query (CustomArraySpecification specification) throws ArrayFormatException {
        List<CustomArray> list = new ArrayList<>();

        for (CustomArray value : arrays) {
            if(specification.specify(value)) {
                list.add(value);
            }
        }
        return list;
    }
}
