package by.dulskij.taskarray.repository.impl;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.repository.CustomArraySpecification;
import by.dulskij.taskarray.service.CustomArrayService;
import by.dulskij.taskarray.service.impl.StreamCustomArrayServiceImpl;

public class MaxValueCustomArraySpecification implements CustomArraySpecification {
    private final int maxToMatch;

    public MaxValueCustomArraySpecification(int maxToMatch) {
        this.maxToMatch = maxToMatch;
    }

    @Override
    public boolean specify(CustomArray array) throws ArrayFormatException {
        CustomArrayService service = new StreamCustomArrayServiceImpl();
        return service.findMax(array) == maxToMatch;
    }
}
