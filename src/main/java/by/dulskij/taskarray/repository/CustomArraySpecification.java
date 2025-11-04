package by.dulskij.taskarray.repository;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;

public interface CustomArraySpecification {
   boolean specify (CustomArray array) throws ArrayFormatException;
}
