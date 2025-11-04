package by.dulskij.taskarray.service.impl;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.service.CustomArrayService;

import java.util.Arrays;

public class StreamCustomArrayServiceImpl implements CustomArrayService {

    @Override
    public int findMin(CustomArray array) throws ArrayFormatException {
        checkArrayLength(array);

        return Arrays.stream(array.getArray())
                .min()
                .orElseThrow(() -> new ArrayFormatException("Array is empty"));
    }

    @Override
    public int findMax(CustomArray array) throws ArrayFormatException {
        checkArrayLength(array);

        return Arrays.stream(array.getArray())
                .max()
                .orElseThrow(() -> new ArrayFormatException("Array is empty"));
    }

    @Override
    public double calculateAverage(CustomArray array) throws ArrayFormatException {
        checkArrayLength(array);

        return Arrays.stream(array.getArray())
                .average()
                .orElseThrow(() -> new ArrayFormatException("Array is empty"));
    }

    @Override
    public int calculateSum(CustomArray array) throws ArrayFormatException{
        checkArrayLength(array);

        return Arrays.stream(array.getArray())
                .sum();
    }

    @Override
    public long calculatePositiveCount(CustomArray array) throws ArrayFormatException{
        checkArrayLength(array);

        return Arrays.stream(array.getArray())
                .filter((n) -> n > 0)
                .count();
    }

    @Override
    public long calculateNegativeCount(CustomArray array) throws ArrayFormatException{
        checkArrayLength(array);

        return Arrays.stream(array.getArray())
                .filter((n) -> n < 0)
                .count();
    }

    @Override
    public int[] replaceByCondition(CustomArray array) throws ArrayFormatException {
        checkArrayLength(array);

        return Arrays.stream(array.getArray())
                .map((num) -> num < 0 ? num * 2 : num)
                .toArray();
    }

    private void checkArrayLength(CustomArray array) throws ArrayFormatException{
        if (array.getArray().length == 0) {
            throw new ArrayFormatException("Array is empty");
        }
    }
}
