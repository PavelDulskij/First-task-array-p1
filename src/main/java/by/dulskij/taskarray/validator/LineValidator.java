package by.dulskij.taskarray.validator;

import by.dulskij.taskarray.exception.ArrayFormatException;

public interface LineValidator {
    boolean isValidValueOfLine(String valueOfLine) throws ArrayFormatException;
}
