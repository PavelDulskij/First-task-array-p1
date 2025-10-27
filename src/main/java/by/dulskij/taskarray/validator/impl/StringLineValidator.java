package by.dulskij.taskarray.validator.impl;

import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.validator.Validator;

import java.util.regex.Pattern;

public class StringLineValidator implements Validator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^-?\\d+(\\.\\d+)?$");

    @Override
    public boolean isValidLine(String line) throws ArrayFormatException {

        if (line == null || line.isBlank()) {
            throw new ArrayFormatException("line is null or empty");
        }

        return NUMBER_PATTERN.matcher(line).matches();
    }
}
