package by.dulskij.taskarray.reader;

import by.dulskij.taskarray.exception.ArrayFormatException;

import java.io.IOException;
import java.util.List;

public interface FileReader {
    List<String> readFile(String path) throws ArrayFormatException, IOException;
}
