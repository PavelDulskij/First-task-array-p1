package by.dulskij.taskarray.repository.impl;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.repository.CustomArraySpecification;

public class IdCustomArraySpecification implements CustomArraySpecification {
    private final int idToMatch;

    public IdCustomArraySpecification(int idToMatch) {
        this.idToMatch = idToMatch;
    }

    @Override
    public boolean specify(CustomArray array) {
        return array.getId() == idToMatch;
    }
}
