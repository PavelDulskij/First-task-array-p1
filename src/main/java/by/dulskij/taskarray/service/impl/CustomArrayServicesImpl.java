package by.dulskij.taskarray.service.impl;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.service.CustomArrayServices;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayServicesImpl implements CustomArrayServices {
    @Override
    public OptionalInt findMin(CustomArray array) {
        return OptionalInt.empty();
    }

    @Override
    public OptionalInt findMax(CustomArray array) {
        return OptionalInt.empty();
    }

    @Override
    public OptionalDouble calculateAverage(CustomArray array) {
        return OptionalDouble.empty();
    }

    @Override
    public OptionalInt calculateSum(CustomArray array) {
        return OptionalInt.empty();
    }

    @Override
    public OptionalInt calculatePositive(CustomArray array) {
        return OptionalInt.empty();
    }

    @Override
    public OptionalInt calculateNegative(CustomArray array) {
        return OptionalInt.empty();
    }

    @Override
    public OptionalInt replaceByCondition(int index, CustomArray array, int oldValue, int newValue) {
        return OptionalInt.empty();
    }
}
