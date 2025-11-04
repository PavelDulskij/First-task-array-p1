package by.dulskij.taskarray.service.impl;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.service.CustomArraySort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomArraySortImpl implements CustomArraySort {

    @Override
    public int[] bubbleSort(CustomArray array) throws ArrayFormatException{
        checkArray(array);

        int[] arr = array.getArray();
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    @Override
    public int[] bucketSort(CustomArray array) throws ArrayFormatException {
        checkArray(array);
        int[] arr = array.getArray();

        int minValue = Arrays.stream(arr).min().getAsInt();
        int maxValue = Arrays.stream(arr).max().getAsInt();
        int bucketCount = (maxValue - minValue) / 10 + 1;

        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : arr) {
            int bucketIndex = (num - minValue) / 10;
            buckets.get(bucketIndex).add(num);
        }

        List<Integer> sortedList = new ArrayList<>();
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            sortedList.addAll(bucket);
        }

        return sortedList.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    public int[] countingSort(CustomArray array) throws ArrayFormatException {
        checkArray(array);
        int[] arr = array.getArray();
        if (arr.length == 0) {
            return new int[0];
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];

        for (int num : arr) {
            count[num - min]++;
        }

        int[] sortedArray = new int[arr.length];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                sortedArray[index++] = i + min;
                count[i]--;
            }
        }

        return sortedArray;
    }

    private void checkArray(CustomArray array) throws ArrayFormatException {
        if(array.getArray().length == 0) {
            throw new ArrayFormatException("array is empty");
        }
    }
}
