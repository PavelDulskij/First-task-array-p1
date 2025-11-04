package by.dulskij.taskarray.validator.impl;

import by.dulskij.taskarray.validator.LineValidator;

import java.util.regex.Pattern;

public class LineValidatorImpl implements LineValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^-?\\d+?$");

    @Override
    public boolean isValidValueOfLine(String value) {
        return NUMBER_PATTERN.matcher(value).matches();
    }
}
