package by.dulskij.taskarray.parser.impl;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.parser.CustomArrayFileParser;
import by.dulskij.taskarray.validator.CustomArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayFileParserImpl implements CustomArrayFileParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String SPACE_DELIMITER_REGEX = "\\s+";

    @Override
    public CustomArray parseLine(String line) throws ArrayFormatException {
        final CustomArrayValidator validator = new by.dulskij.taskarray.validator.impl.CustomArrayValidatorImpl();
        logger.info("Parsing line: {}", line);
        List<String> numbers = List.of(line.trim().split(SPACE_DELIMITER_REGEX));
        List<Integer> intList = new ArrayList<>();
        for (String num : numbers) {
            if (validator.isValidValueOfLine(num)) {
                try {
                    intList.add(Integer.parseInt(num));
                    logger.info("{} is added to array", num);
                } catch (NumberFormatException e) {
                    logger.error("Invalid number: {}", num);
                    throw new ArrayFormatException("Invalid number: " + num, e);
                }
            } else {
                logger.warn("Skipped invalid number: {}", num);
            }
        }
        logger.info("Parsing is successful");
        int[] array = intList.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        CustomArray newArr = new CustomArray.Builder()
                .setArray(array)
                .build();

        return newArr;
    }
}