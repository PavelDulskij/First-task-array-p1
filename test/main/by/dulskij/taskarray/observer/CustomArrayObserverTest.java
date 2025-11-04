package by.dulskij.taskarray.observer;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.entity.CustomArrayParameters;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.observer.CustomArrayObserver;
import by.dulskij.taskarray.observer.impl.CustomArrayObserverImp;
import by.dulskij.taskarray.warehouse.CustomArrayWarehouse;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomArrayObserverTest {
    @Test
    void observerShouldUpdateWarehouseCorrectly() throws ArrayFormatException {
        CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
        CustomArray array = new CustomArray.Builder()
                .setId(456)
                .setArray(new int[]{4, 5, 6, 9, 75, 64})
                .build();

        CustomArrayObserver observer = new CustomArrayObserverImp();
        observer.update(array);

        Map<Integer, CustomArrayParameters> map = warehouse.getCustomArrayParameters();
        CustomArrayParameters retrievedParameters = map.get(456);

        assertEquals(4, retrievedParameters.getMinValue(), "Min value should be 4");
        assertEquals(75, retrievedParameters.getMaxValue(), "Max value should be 75");
        assertEquals(27.166666, retrievedParameters.getAvgValue(), 0.001, "Avg value should be 27.1666667");
        assertEquals(163, retrievedParameters.getArraySum(), "Sum should be 163");
    }
}