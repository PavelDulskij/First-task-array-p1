package by.dulskij.taskarray.service;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;

public interface CustomArrayServices {
    int findMin(CustomArray array) throws ArrayFormatException;
    int findMax(CustomArray array) throws ArrayFormatException;
    double calculateAverage(CustomArray array) throws ArrayFormatException;
    int calculateSum(CustomArray array);
    int calculatePositive(CustomArray array);
    int calculateNegative(CustomArray array);
    int[] replaceByCondition(int index, CustomArray array, int newValue) throws ArrayFormatException;
}
