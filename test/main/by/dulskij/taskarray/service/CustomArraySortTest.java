package by.dulskij.taskarray.service;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.service.CustomArraySort;
import by.dulskij.taskarray.service.impl.CustomArraySortImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArraySortTest {
    @Test
    public void bubbleSortShouldReturnSortedArr() throws ArrayFormatException {
        CustomArraySort sort = new CustomArraySortImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{3, 1, 4, -12, 55, 24, 35, -54})
                .build();

        int[] expected = new int[]{-54, -12, 1, 3, 4, 24, 35, 55};
        int[] actual = sort.bubbleSort(array);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void countingSortShouldReturnSortedArr() throws ArrayFormatException{
        CustomArraySort sort = new CustomArraySortImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{3, 1, 4, -12, 55, 24, 35, -54})
                .build();

        int[] expected = new int[]{-54, -12, 1, 3, 4, 24, 35, 55};
        int[] actual = sort.countingSort(array);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void bucketSortShouldReturnSortedArr() throws ArrayFormatException{
        CustomArraySort sort = new CustomArraySortImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{3, 1, 4, -12, 55, 24, 35, -54})
                .build();

        int[] expected = new int[]{-54, -12, 1, 3, 4, 24, 35, 55};
        int[] actual = sort.bucketSort(array);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void whenEmptyArrayThenThrowArrayFormatException() throws ArrayFormatException {
        CustomArraySort sort = new CustomArraySortImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{})
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            sort.bucketSort(array);
        });
        assertThrows(ArrayFormatException.class, () -> {
            sort.bucketSort(array);
        });
        assertThrows(ArrayFormatException.class, () -> {
            sort.countingSort(array);
        });
    }
}