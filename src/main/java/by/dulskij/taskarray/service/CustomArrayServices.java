package by.dulskij.taskarray.service;

import by.dulskij.taskarray.entity.CustomArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface CustomArrayServices {
    OptionalInt findMin(CustomArray array);
    OptionalInt findMax(CustomArray array);
    OptionalDouble calculateAverage(CustomArray array);
    OptionalInt calculateSum(CustomArray array);
    OptionalInt calculatePositive(CustomArray array);
    OptionalInt calculateNegative(CustomArray array);
    OptionalInt replaceByCondition(int index, CustomArray array, int oldValue, int newValue);
}
