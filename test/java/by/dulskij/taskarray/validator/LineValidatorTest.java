package by.dulskij.taskarray.validator;

import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.validator.impl.LineValidatorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineValidatorTest {
    @Test
    void whenValueIsCorrectThenReturnTrue() throws ArrayFormatException {
        LineValidator validator = new LineValidatorImpl();
        boolean result = validator.isValidValueOfLine("1324");
        assertTrue(result);
    }

    @Test
    void whenValueIsInCorrectThenReturnFalse() throws ArrayFormatException {
        LineValidator validator = new LineValidatorImpl();
        boolean result = validator.isValidValueOfLine("132few4");
        assertFalse(result);
    }
}