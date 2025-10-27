package by.dulskij.taskarray.service.impl;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.service.CustomArrayServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;

public class CustomArrayServicesImpl implements CustomArrayServices {

    private static final Logger log = LogManager.getLogger(CustomArrayServicesImpl.class);

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
    public int calculateSum(CustomArray array) {
        int[] arr = array.getArray();
        return Arrays.stream(arr).sum();
    }

    @Override
    public int calculatePositive(CustomArray array) {
        int[] arr = array.getArray();
        return Arrays.stream(arr)
                .filter((n) -> n > 0)
                .sum();
    }

    @Override
    public int calculateNegative(CustomArray array) {
        int[] arr = array.getArray();
        return Arrays.stream(arr)
                .filter((n) -> n < 0)
                .sum();
    }

    @Override
    public int[] replaceByCondition(int index, CustomArray array, int newValue) throws ArrayFormatException {
        int[] arr = array.getArray();

        if(index < 0 || index > arr.length) {
            throw new ArrayFormatException("Incorrect index");
        }

        arr[index] = newValue;
        return arr.clone();
    }
}
