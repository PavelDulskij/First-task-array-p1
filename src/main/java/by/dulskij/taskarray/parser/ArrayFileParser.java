package by.dulskij.taskarray.parser;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;

public interface ArrayFileParser {
    CustomArray parseLine(String line) throws ArrayFormatException;
}
