package by.dulskij.taskarray.entity;

import by.dulskij.taskarray.exception.ArrayFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayTest {
    @Test
    void whenCreateArrayThenReturnNewArray() throws ArrayFormatException {
        int[] inputArray = {1, 2, 3, 4, 5};
        CustomArray customArray = new CustomArray.Builder()
                .setArray(inputArray)
                .setId(1)
                .build();

        assertArrayEquals(inputArray, customArray.getArray());
        assertEquals(1, customArray.getId());
    }

    @Test
    void whenArrayIsNullThenReturnEmptyArray() throws ArrayFormatException {
        CustomArray customArray = new CustomArray.Builder()
                .setArray(null)
                .setId(2)
                .build();

        assertArrayEquals(new int[0], customArray.getArray());
    }

    @Test
    void whenCompareEqualArraysThenReturnTrue() throws ArrayFormatException {
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
    void whenCompareDifferentArraysThenReturnFalse() throws ArrayFormatException {
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
    void whenCloneArrayThenOriginalIsUnchanged() throws ArrayFormatException {
        int[] inputArray = {10, 20, 30};
        CustomArray customArray = new CustomArray.Builder()
                .setArray(inputArray)
                .setId(3)
                .build();

        inputArray[0] = 100;
        assertArrayEquals(new int[]{10, 20, 30}, customArray.getArray());
    }

    @Test
    void whenToStringCalledThenReturnStringRepresentation() throws ArrayFormatException {
        CustomArray customArray = new CustomArray.Builder()
                .setArray(new int[]{7, 8, 9})
                .setId(4)
                .build();

        assertEquals("CustomArray{array=[7, 8, 9], id=4}", customArray.toString());
    }
    @Test
    void whenEqualArraysThenHashesShouldBeEqual() throws ArrayFormatException {
        CustomArray array1 = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3})
                .setId(1)
                .build();

        CustomArray array2 = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3})
                .setId(1)
                .build();

        assertEquals(array1, array2);
        assertEquals(array1.hashCode(), array2.hashCode());
    }

    @Test
    void whenDifferentArraysThenHashesShouldNotBeEqual() throws ArrayFormatException {
        CustomArray array1 = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3})
                .setId(1)
                .build();

        CustomArray array2 = new CustomArray.Builder()
                .setArray(new int[]{4, 5, 6})
                .setId(2)
                .build();

        assertNotEquals(array1, array2);
        assertNotEquals(array1.hashCode(), array2.hashCode());
    }

    @Test
    void whenSameObjectThenEqualAndHashCodeShouldMatch() throws ArrayFormatException {
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{7, 8, 9})
                .setId(3)
                .build();

        assertEquals(array, array);
        assertEquals(array.hashCode(), array.hashCode());
    }

    @Test
    void whenDifferentObjectTypeThenNotEqual() throws ArrayFormatException {
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3})
                .setId(1)
                .build();

        String notAnArray = "some string";
        assertNotEquals(array, notAnArray);
    }
}