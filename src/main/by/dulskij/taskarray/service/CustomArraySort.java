package by.dulskij.taskarray.service;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;

public interface CustomArraySort {
    int[] bubbleSort (CustomArray array) throws ArrayFormatException;
    int[] bucketSort (CustomArray array) throws ArrayFormatException;
    int[] countingSort (CustomArray array) throws ArrayFormatException;
}
