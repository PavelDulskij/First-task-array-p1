package by.dulskij.taskarray.service;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;

public interface CustomArrayService {
    int findMin(CustomArray array) throws ArrayFormatException;
    int findMax(CustomArray array) throws ArrayFormatException;
    double calculateAverage(CustomArray array) throws ArrayFormatException;
    int calculateSum(CustomArray array) throws ArrayFormatException;;
    long calculatePositiveCount(CustomArray array) throws ArrayFormatException;;
    long calculateNegativeCount(CustomArray array) throws ArrayFormatException;;
    int[] replaceByCondition(CustomArray array) throws ArrayFormatException;
}
