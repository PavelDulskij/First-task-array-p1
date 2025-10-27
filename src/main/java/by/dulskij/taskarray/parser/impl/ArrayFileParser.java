package by.dulskij.taskarray.parser.impl;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.parser.FileParser;
import by.dulskij.taskarray.validator.Validator;
import by.dulskij.taskarray.validator.impl.StringLineValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ArrayFileParser implements FileParser {
    private static final Logger logger = LogManager.getLogger();
    private final Validator validator = new StringLineValidator();

    @Override
    public CustomArray parseLine(String line) throws ArrayFormatException {
        if (line == null || line.isBlank()) {
            throw new ArrayFormatException(String.format("%s is null or empty", line));
        }

        List<String> numbers = List.of(line.split(" "));
        List<Integer> intList = new ArrayList<>();
        for (String num : numbers) {
            if (validator.isValidLine(num)) {
                try {
                    intList.add(Integer.parseInt(num));
                    logger.log(Level.INFO, "{} is added to array", num);
                } catch (NumberFormatException e) {
                    throw new ArrayFormatException("invalid number: " + num, e);
                }
            } else {
                continue;
            }
        }
        logger.log(Level.INFO, "parsing is successful");
        int[] array = intList.stream().mapToInt(Integer::intValue).toArray();
        return new CustomArray(array);
    }
}
