package by.dulskij.taskarray.validator.impl;

import by.dulskij.taskarray.validator.CustomArrayValidator;

import java.util.regex.Pattern;

public class CustomArrayValidatorImpl implements CustomArrayValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^-?\\d+?$");

    @Override
    public boolean isValidValueOfLine(String value) {
        return NUMBER_PATTERN.matcher(value).matches();
    }
}
