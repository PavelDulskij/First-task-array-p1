package by.dulskij.taskarray.validator;

import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.validator.CustomArrayValidator;
import by.dulskij.taskarray.validator.impl.CustomArrayValidatorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayValidatorTest {
    @Test
    void whenValueIsCorrectThenReturnTrue() throws ArrayFormatException {
        CustomArrayValidator validator = new CustomArrayValidatorImpl();
        boolean result = validator.isValidValueOfLine("1324");
        assertTrue(result);
    }

    @Test
    void whenValueIsInCorrectThenReturnFalse() throws ArrayFormatException {
        CustomArrayValidator validator = new CustomArrayValidatorImpl();
        boolean result = validator.isValidValueOfLine("132few4");
        assertFalse(result);
    }
}