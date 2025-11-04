package by.dulskij.taskarray.parser;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.parser.CustomArrayFileParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayFileParserTest {
    @Test
    void whenParseLineThenReturnNewArray() throws ArrayFormatException {
        CustomArrayFileParser parser = new by.dulskij.taskarray.parser.impl.CustomArrayFileParserImpl();

        CustomArray array = parser.parseLine("    1 2   3    4 5   6 7 4");
        int[] actual = array.getArray();
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 4};

        assertArrayEquals(expected,actual);
    }

    @Test
    void whenParseInvalidLineThenReturnEmptyArray() throws ArrayFormatException {
        CustomArrayFileParser parser = new by.dulskij.taskarray.parser.impl.CustomArrayFileParserImpl();
        CustomArray array = parser.parseLine("1t 2e 3y 4few ,,jh5");

        int[] expected = new int[0];
        int[] actual = array.getArray();

        assertArrayEquals(expected, actual);
    }

    @Test
    void whenParseEmptyLineThenReturnEmptyArray() throws ArrayFormatException {
        CustomArrayFileParser parser = new by.dulskij.taskarray.parser.impl.CustomArrayFileParserImpl();
        CustomArray array = parser.parseLine("");

        int[] expected = new int[]{};
        int[] actual = array.getArray();

        assertArrayEquals(expected, actual);
    }
}