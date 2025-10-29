package by.dulskij.taskarray.service.impl;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.service.CustomArrayServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;

public class CustomArrayServicesImpl implements CustomArrayServices {

    private static final Logger logger = LogManager.getLogger(CustomArrayServicesImpl.class);

    @Override
    public int findMin(CustomArray array) throws ArrayFormatException {
        int[] arr = array.getArray();
        return Arrays.stream(arr)
                .min()
                .orElseThrow(() -> new ArrayFormatException("Array is empty"));
    }

    @Override
    public int findMax(CustomArray array) throws ArrayFormatException {
        int[] arr = array.getArray();
        return Arrays.stream(arr)
                .max()
                .orElseThrow(() -> new ArrayFormatException("Array is empty"));
    }

    @Override
    public double calculateAverage(CustomArray array) throws ArrayFormatException {
        int[] arr = array.getArray();
        return Arrays.stream(arr)
                .average()
                .orElseThrow(() -> new ArrayFormatException("Array is empty"));
    }

    @Override
    public int calculateSum(CustomArray array) throws ArrayFormatException{
        checkArrayLength(array);

        int[] arr = array.getArray();
        return Arrays.stream(arr)
                .sum();
    }

    @Override
    public long calculatePositiveCount(CustomArray array) throws ArrayFormatException{
        checkArrayLength(array);

        int[] arr = array.getArray();
        return Arrays.stream(arr)
                .filter((n) -> n > 0)
                .count();
    }

    @Override
    public long calculateNegativeCount(CustomArray array) throws ArrayFormatException{
        checkArrayLength(array);

        int[] arr = array.getArray();
        return Arrays.stream(arr)
                .filter((n) -> n < 0)
                .count();
    }

    @Override
    public int[] replaceByCondition(int index, CustomArray array, int newValue) throws ArrayFormatException {
        checkArrayLength(array);

        int[] arr = array.getArray();

        if(index < 0 || index > arr.length) {
            throw new ArrayFormatException("Incorrect index");
        }

        arr[index] = newValue;
        return arr.clone();
    }

    private void checkArrayLength(CustomArray array) throws ArrayFormatException{
        if (array.getArray().length == 0) {
            throw new ArrayFormatException("Array is empty");
        }
    }
}
