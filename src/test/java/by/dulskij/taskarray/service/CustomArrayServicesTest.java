package by.dulskij.taskarray.service;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.service.impl.CustomArrayServicesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CustomArrayServicesTest {

    @Test
    void findMinMethodShouldReturnMinValue() throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
                .build();

        int actual = services.findMin(array);
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    void findMinMethodInEmptyArrayShouldThrowArrayFormatException() throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{})
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            int actual = services.findMin(array);
        });
    }

    @Test
    void findMaxMethodShouldReturnMinValue() throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
                .build();

        int actual = services.findMax(array);
        int expected = 9;

        assertEquals(expected, actual);
    }

    @Test
    void findMaxMethodInEmptyArrayShouldThrowArrayFormatException() throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{})
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            int actual = services.findMax(array);
        });
    }

    @Test
    void calcAVGMethodShouldReturnValue() throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
                .build();
        double actual = services.calculateAverage(array);
        double expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void calcAVGMethodInEmptyArrayShouldThrowArrayFormatException() throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{})
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            double actual = services.calculateAverage(array);
        });
    }

    @Test
    void calcSumMethodShouldReturnSum() throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
                .build();

        double actual = services.calculateSum(array);
        double expected = 45;

        assertEquals(expected, actual);
    }

    @Test
    void calcSumMethodInEmptyArrayShouldThrowArrayFormatException() throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(null)
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            double actual = services.calculateSum(array);
        });
    }
    @Test
    void calcPositiveCountMethodShouldReturnSum() throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
                .build();

        double actual = services.calculatePositiveCount(array);
        double expected = 9;

        assertEquals(expected, actual);
    }

    @Test
    void calcPositiveCountMethodInEmptyArrayShouldThrowArrayFormatException() throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(null)
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            double actual = services.calculatePositiveCount(array);
        });
    }

    @Test
    void calcNegativeCountMethodShouldReturnSum() throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{-1, -2, -3, 4, -5, 6, -7, 8, -9})
                .build();

        double actual = services.calculateNegativeCount(array);
        double expected = 6;

        assertEquals(expected, actual);
    }

    @Test
    void calcNegativeCountMethodInEmptyArrayShouldThrowArrayFormatException() throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(null)
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            double actual = services.calculateNegativeCount(array);
        });
    }

    @Test
    void replaceByConditionMethodShouldReturnNewArray() throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{-1, -2, -3, 4, -5, 6, -7, 8, -9})
                .build();

        int[] actual = services.replaceByCondition(1, array, 65);
        int[] expected = new int[]{-1, 65, -3, 4, -5, 6, -7, 8, -9};

        assertArrayEquals(expected, actual);
    }

    @Test
    void replaceByConditionMethodInEmptyArrayShouldThrowArrayFormatException()  throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{})
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            int[] actual = services.replaceByCondition(1, array, 65);
        });
    }

    @Test
    void incorrectIndexInArrayShouldThrowArrayFormatException() throws ArrayFormatException {
        CustomArrayServices services = new CustomArrayServicesImpl();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{-1, 65, -3, 4, -5, 6, -7, 8, -9})
                .build();

        assertThrows(ArrayFormatException.class, () -> {
            int[] actual = services.replaceByCondition(45, array, 65);
        });
    }
}