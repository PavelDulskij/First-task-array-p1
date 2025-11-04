package by.dulskij.taskarray.repository.impl;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.repository.CustomArraySpecification;
import by.dulskij.taskarray.service.CustomArrayService;
import by.dulskij.taskarray.service.impl.StreamCustomArrayServiceImpl;

public class SumCustomArraySpecification implements CustomArraySpecification {
    private final int sumToMatch;

    public SumCustomArraySpecification(int sumToMatch) {
        this.sumToMatch = sumToMatch;
    }

    @Override
    public boolean specify(CustomArray array) throws ArrayFormatException {
        CustomArrayService service = new StreamCustomArrayServiceImpl();
        return service.calculateSum(array) == sumToMatch;
    }
}
