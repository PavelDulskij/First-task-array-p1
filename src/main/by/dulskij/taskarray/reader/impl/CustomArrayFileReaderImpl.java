package by.dulskij.taskarray.reader.impl;

import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.reader.CustomArrayFileReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class CustomArrayFileReaderImpl implements CustomArrayFileReader {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public List<String> readFile(String path) throws ArrayFormatException {
        logger.log(Level.INFO, "readFile method called");
        if (path == null || path.isBlank()) {
            throw new ArrayFormatException(String.format("file name %s is null or empty", path));
        }
        Path dataFile = Path.of(path);
        try {
            List<String> lines = Files.readAllLines(dataFile);
            logger.log(Level.INFO, "Read file {} successfully", dataFile.getFileName());
            return lines;
        } catch (IOException e) {
            throw new ArrayFormatException(String.format("input error during reading file %s",
                                    dataFile.getFileName()), e);
        }
    }
}
