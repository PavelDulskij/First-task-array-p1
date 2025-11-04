package by.dulskij.taskarray.observer;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;

public interface CustomArrayObserver {
    void update(CustomArray array) throws ArrayFormatException;
}
