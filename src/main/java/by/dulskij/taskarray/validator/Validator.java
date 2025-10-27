package by.dulskij.taskarray.validator;

import by.dulskij.taskarray.exception.ArrayFormatException;

public interface Validator {
    boolean isValidLine(String line) throws ArrayFormatException;
}
