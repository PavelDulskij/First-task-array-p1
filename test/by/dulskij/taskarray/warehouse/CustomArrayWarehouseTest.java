package by.dulskij.taskarray.warehouse;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.entity.CustomArrayParameters;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.observer.CustomArrayObserver;
import by.dulskij.taskarray.observer.impl.CustomArrayObserverImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayWarehouseTest {
    private CustomArrayWarehouse warehouse;
    @BeforeEach
    void setUp() {
        warehouse = CustomArrayWarehouse.getInstance();
    }

    @Test
    void whenAnotherWarehouseCreatedItShouldPointToTheSameInstance() {
        CustomArrayWarehouse another = CustomArrayWarehouse.getInstance();
        assertSame(another, warehouse, "Both instances should be the same");
    }

    @Test
    void whenGetMethodsCalledThenReturnValues() {
        CustomArrayParameters parameters = new CustomArrayParameters(-5, 10,
                6.54, 15);

        CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
        warehouse.put(1, parameters);

        Map<Integer, CustomArrayParameters> map = warehouse.getCustomArrayParameters();

        assertTrue(map.containsKey(1), "Map should contain key 1");

        CustomArrayParameters retrievedParameters = map.get(1);

        assertEquals(-5, retrievedParameters.getMinValue(), "Min value should be -5");
        assertEquals(10, retrievedParameters.getMaxValue(), "Max value should be 10");
        assertEquals(6.54, retrievedParameters.getAvgValue(), "Avg value should be 6.54");
        assertEquals(15, retrievedParameters.getArraySum(), "Sum should be 15");
    }

    @Test
    void whenGetCustomArrayParametersCalledInitiallyThenReturnEmptyMap() {
        Map<Integer, CustomArrayParameters> map = warehouse.getCustomArrayParameters();

        assertTrue(map.isEmpty(), "Map should be empty initially");
    }
}