package by.dulskij.taskarray.service.impl;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.service.CustomArrayService;

public class DefaultCustomArrayServiceImpl implements CustomArrayService {
    @Override
    public int findMin(CustomArray array) throws ArrayFormatException {
        checkArrayLength(array);
        int[] arr = array.getArray();
        int min = arr[0];

        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }

    @Override
    public int findMax(CustomArray array) throws ArrayFormatException {
        checkArrayLength(array);
        int[] arr = array.getArray();
        int max = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    @Override
    public double calculateAverage(CustomArray array) throws ArrayFormatException {
        checkArrayLength(array);
        int[] arr = array.getArray();
        double avg = 0;

        for (int num : arr) {
            avg += num;
        }
        return avg / arr.length;
    }

    @Override
    public int calculateSum(CustomArray array) throws ArrayFormatException {
        checkArrayLength(array);
        int[] arr = array.getArray();
        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        return sum;
    }

    @Override
    public long calculatePositiveCount(CustomArray array) throws ArrayFormatException {
        checkArrayLength(array);
        int[] arr = array.getArray();
        int positiveCount = 0;

        for (int num : arr) {
            if (num > 0) {
                positiveCount++;
            }
        }

        return positiveCount;
    }

    @Override
    public long calculateNegativeCount(CustomArray array) throws ArrayFormatException {
        checkArrayLength(array);
        int[] arr = array.getArray();
        int negativeCount = 0;

        for (int num : arr) {
            if (num < 0) {
                negativeCount++;
            }
        }

        return negativeCount;
    }

    @Override
    public int[] replaceByCondition(CustomArray array) throws ArrayFormatException {
        checkArrayLength(array);
        int[] arr = array.getArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] *= 2;
            }
        }

        return arr;
    }

    private void checkArrayLength(CustomArray array) throws ArrayFormatException {
        if (array.getArray().length == 0) {
            throw new ArrayFormatException("Array is empty");
        }
    }
}
