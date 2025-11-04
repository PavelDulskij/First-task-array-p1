package by.dulskij.taskarray.reader;

import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.reader.impl.ArrayFileReaderImpl;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFileReaderTest {
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

    @Test
    void emptyLinesShouldReturnListOFEmptyLines() throws ArrayFormatException, IOException {
        ArrayFileReader reader = new ArrayFileReaderImpl() ;
        String testFilePath = "data/testData.txt";

        List<String> expected = List.of("", "", "", "", "", "", "", "");
        Files.write(Paths.get(testFilePath), expected);

        List<String> actual = reader.readFile(testFilePath);

        assertLinesMatch(expected, actual);

        Files.delete(Paths.get(testFilePath));
    }
}