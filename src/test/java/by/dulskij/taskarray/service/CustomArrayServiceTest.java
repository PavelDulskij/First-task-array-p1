package by.dulskij.taskarray.service;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.service.impl.DefaultCustomArrayServiceImpl;
import by.dulskij.taskarray.service.impl.StreamCustomArrayServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CustomArrayServiceTest {

    @Test
    void findMinMethodShouldReturnMinValue() throws ArrayFormatException {
        CustomArrayService streamServices = new StreamCustomArrayServiceImpl();
        CustomArrayService defaultServices = new DefaultCustomArrayServiceImpl();

        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
                .build();

        int actual1 = streamServices.findMin(array);
        int actual2 = defaultServices.findMin(array);

        int expected = 1;

        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }

    @Test
    void findMinMethodInEmptyArrayShouldThrowArrayFormatException() throws ArrayFormatException {
        CustomArrayService streamServices = new StreamCustomArrayServiceImpl();
        CustomArrayService defaultServices = new DefaultCustomArrayServiceImpl();

        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{})
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            int actual = streamServices.findMin(array);
        });

        assertThrows(ArrayFormatException.class, () -> {
            int actual = defaultServices.findMin(array);
        });
    }

    @Test
    void findMaxMethodShouldReturnMinValue() throws ArrayFormatException {
        CustomArrayService streamServices = new StreamCustomArrayServiceImpl();
        CustomArrayService defaultServices = new DefaultCustomArrayServiceImpl();

        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
                .build();

        int actual1 = streamServices.findMax(array);
        int actual2 = defaultServices.findMax(array);

        int expected = 9;

        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }

    @Test
    void findMaxMethodInEmptyArrayShouldThrowArrayFormatException() throws ArrayFormatException {
        CustomArrayService streamServices = new StreamCustomArrayServiceImpl();
        CustomArrayService defaultServices = new DefaultCustomArrayServiceImpl();

        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{})
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            int actual = streamServices.findMax(array);
        });

        assertThrows(ArrayFormatException.class, () -> {
            int actual = defaultServices.findMax(array);
        });
    }

    @Test
    void calcAVGMethodShouldReturnValue() throws ArrayFormatException {
        CustomArrayService streamServices = new StreamCustomArrayServiceImpl();
        CustomArrayService defaultServices = new DefaultCustomArrayServiceImpl();

        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
                .build();
        double actual1 = streamServices.calculateAverage(array);
        double actual2 = streamServices.calculateAverage(array);
        double expected = 5;

        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }

    @Test
    void calcAVGMethodInEmptyArrayShouldThrowArrayFormatException() throws ArrayFormatException {
        CustomArrayService services = new StreamCustomArrayServiceImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{})
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            double actual = services.calculateAverage(array);
        });
    }

    @Test
    void calcSumMethodShouldReturnSum() throws ArrayFormatException {
        CustomArrayService streamServices = new StreamCustomArrayServiceImpl();
        CustomArrayService defaultServices = new DefaultCustomArrayServiceImpl();

        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
                .build();

        double actual1 = streamServices.calculateSum(array);
        double actual2 = defaultServices.calculateSum(array);
        double expected = 45;

        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }

    @Test
    void calcSumMethodInEmptyArrayShouldThrowArrayFormatException() throws ArrayFormatException {
        CustomArrayService services = new StreamCustomArrayServiceImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(null)
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            double actual = services.calculateSum(array);
        });
    }
    @Test
    void calcPositiveCountMethodShouldReturnSum() throws ArrayFormatException {
        CustomArrayService services = new StreamCustomArrayServiceImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
                .build();

        double actual = services.calculatePositiveCount(array);
        double expected = 9;

        assertEquals(expected, actual);
    }

    @Test
    void calcPositiveCountMethodInEmptyArrayShouldThrowArrayFormatException() throws ArrayFormatException {
        CustomArrayService streamServices = new StreamCustomArrayServiceImpl();
        CustomArrayService defaultServices = new DefaultCustomArrayServiceImpl();

        CustomArray array = new CustomArray.Builder()
                .setArray(null)
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            double actual = streamServices.calculatePositiveCount(array);
        });
        assertThrows(ArrayFormatException.class, () -> {
            double actual = defaultServices.calculatePositiveCount(array);
        });
    }

    @Test
    void calcNegativeCountMethodShouldReturnSum() throws ArrayFormatException {
        CustomArrayService streamServices = new StreamCustomArrayServiceImpl();
        CustomArrayService defaultServices = new DefaultCustomArrayServiceImpl();

        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{-1, -2, -3, 4, -5, 6, -7, 8, -9})
                .build();

        double actual1 = streamServices.calculateNegativeCount(array);
        double actual2 = defaultServices.calculateNegativeCount(array);
        double expected = 6;

        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }

    @Test
    void calcNegativeCountMethodInEmptyArrayShouldThrowArrayFormatException() throws ArrayFormatException {
        CustomArrayService streamServices = new StreamCustomArrayServiceImpl();
        CustomArrayService defaultServices = new DefaultCustomArrayServiceImpl();

        CustomArray array = new CustomArray.Builder()
                .setArray(null)
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            double actual = streamServices.calculateNegativeCount(array);
        });
        assertThrows(ArrayFormatException.class, () -> {
            double actual = defaultServices.calculateNegativeCount(array);
        });

    }

    @Test
    void replaceByConditionMethodShouldReturnNewArray() throws ArrayFormatException {
        CustomArrayService streamServices = new StreamCustomArrayServiceImpl();
        CustomArrayService defaultServices = new DefaultCustomArrayServiceImpl();

        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{-1, -2, -3, 4, -5, 6, -7, 8, -9})
                .build();

        int[] actual1 = streamServices.replaceByCondition(array);
        int[] actual2 = streamServices.replaceByCondition(array);
        int[] expected = new int[]{-2, -4, -6, 4, -10, 6, -14, 8, -18};

        assertArrayEquals(expected, actual1);
        assertArrayEquals(expected, actual2);
    }

    @Test
    void replaceByConditionMethodInEmptyArrayShouldThrowArrayFormatException()  throws ArrayFormatException {
        CustomArrayService streamServices = new StreamCustomArrayServiceImpl();
        CustomArrayService defaultServices = new DefaultCustomArrayServiceImpl();

        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{})
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            int[] actual = streamServices.replaceByCondition(array);
        });
        assertThrows(ArrayFormatException.class, () -> {
            int[] actual = defaultServices.replaceByCondition(array);
        });
    }
}