package by.dulskij.taskarray.entity;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayTest {

    @Test
    void testCustomArrayCreation() throws ArrayFormatException {
        int[] inputArray = {1, 2, 3, 4, 5};
        CustomArray customArray = new CustomArray.Builder()
                .setArray(inputArray)
                .setId(1)
                .build();

        assertArrayEquals(inputArray, customArray.getArray());
        assertEquals(1, customArray.getId());
    }

    @Test
    void testCustomArrayEquals() throws ArrayFormatException {
        CustomArray array1 = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3})
                .setId(1)
                .build();

        CustomArray array2 = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3})
                .setId(1)
                .build();

        assertEquals(array1, array2);
    }

    @Test
    void testCustomArrayNotEquals() throws ArrayFormatException {
        CustomArray array1 = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3})
                .setId(1)
                .build();

        CustomArray array2 = new CustomArray.Builder()
                .setArray(new int[]{4, 5, 6})
                .setId(2)
                .build();

        assertNotEquals(array1, array2);
    }

    @Test
    void testCustomArrayClone() throws ArrayFormatException {
        int[] inputArray = {10, 20, 30};
        CustomArray customArray = new CustomArray.Builder()
                .setArray(inputArray)
                .setId(2)
                .build();

        // Проверка, что массив клонируется
        inputArray[0] = 100; // Изменяем оригинальный массив
        assertArrayEquals(new int[]{10, 20, 30}, customArray.getArray());
    }

    @Test
    void testCustomArrayToString() throws ArrayFormatException {
        CustomArray customArray = new CustomArray.Builder()
                .setArray(new int[]{7, 8, 9})
                .setId(3)
                .build();

        assertEquals("CustomArray{array=[7, 8, 9], id=3}", customArray.toString());
    }

    @Test
    void testCustomArrayBuilderWithNullArray() throws ArrayFormatException {
        CustomArray customArray = new CustomArray.Builder()
                .setArray(null)
                .setId(4)
                .build();

        assertArrayEquals(new int[0], customArray.getArray()); // Проверка, что массив пустой
    }
}