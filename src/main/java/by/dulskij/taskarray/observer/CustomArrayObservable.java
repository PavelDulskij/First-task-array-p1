package by.dulskij.taskarray.observer;

import by.dulskij.taskarray.exception.ArrayFormatException;

public interface CustomArrayObservable {
    void addObserver(CustomArrayObserver observer) throws ArrayFormatException;
    void removeObserver(CustomArrayObserver observer) throws ArrayFormatException;

    void notifyObservers(CustomArrayObserver observer) throws ArrayFormatException;
}
