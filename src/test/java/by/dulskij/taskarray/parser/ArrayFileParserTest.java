package by.dulskij.taskarray.parser;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.parser.impl.ArrayFileParserImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFileParserTest {
    @Test
    void whenParseLineThenReturnNewArray() throws ArrayFormatException {
        ArrayFileParser parser = new ArrayFileParserImpl();

        CustomArray array = parser.parseLine("    1 2   3    4 5   6 7 4");
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
    void whenParseEmptyLineThenReturnEmptyArray() throws ArrayFormatException {
        ArrayFileParser parser = new ArrayFileParserImpl();
        CustomArray array = parser.parseLine("");

        int[] expected = new int[]{};
        int[] actual = array.getArray();

        assertArrayEquals(expected, actual);
    }
}