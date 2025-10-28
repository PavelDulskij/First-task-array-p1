package by.dulskij.taskarray;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.parser.ArrayFileParser;
import by.dulskij.taskarray.parser.impl.ArrayFileParserImpl;
import by.dulskij.taskarray.reader.ArrayFileReader;
import by.dulskij.taskarray.reader.impl.ArrayFileReaderImpl;
import by.dulskij.taskarray.validator.LineValidator;
import by.dulskij.taskarray.validator.impl.LineValidatorImpl;
import org.junit.jupiter.api.Test;

import javax.xml.validation.Validator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
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

    @Test
    void whenParseLineThenReturnNewArray() throws ArrayFormatException {
        ArrayFileParser parser = new ArrayFileParserImpl();

        CustomArray array = parser.parseLine("1 2 3 4 5 6 7 4");
        int[] actual = array.getArray();
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 4};

        assertArrayEquals(expected,actual);
    }

    @Test
    void whenParseInvalidLineThenReturnEmptyArray() throws ArrayFormatException {
        ArrayFileParser parser = new ArrayFileParserImpl();
        CustomArray array = parser.parseLine("1e 2x 3y 4few ,,jh5");

        assertEquals(0, array.getArray().length);
    }

    @Test
    void whenReadFileThenReturnListOfStrings() throws ArrayFormatException, IOException {
        ArrayFileReader reader = new ArrayFileReaderImpl();
        String testFilePath = "data/testData.txt";
        File testFile = new File(testFilePath);
        try {
            testFile.createNewFile();
        } catch (IOException e) {
            throw new ArrayFormatException(e);
        }

        List<String> expected = List.of("string1", "string2", "string3", "string4", "string5");
        Files.write(Paths.get(testFilePath), expected);

        List<String> actual = reader.readFile(testFilePath);

        assertLinesMatch(expected, actual);

        Files.delete(Paths.get(testFilePath));
    }

    @Test
    void InvalidPathShouldThrowArrayFormatException() throws ArrayFormatException, IOException {
        ArrayFileReader reader = new ArrayFileReaderImpl();
        String path = "someFolder/listOfArrays.txt";

        assertThrows(ArrayFormatException.class, () -> {
            List<String> lines = reader.readFile(path);
        });
    }


}