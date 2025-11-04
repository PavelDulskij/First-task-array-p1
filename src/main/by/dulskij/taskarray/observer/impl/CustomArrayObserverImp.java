package by.dulskij.taskarray.observer.impl;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.entity.CustomArrayParameters;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.observer.CustomArrayObserver;
import by.dulskij.taskarray.service.CustomArrayService;
import by.dulskij.taskarray.service.impl.StreamCustomArrayServiceImpl;
import by.dulskij.taskarray.warehouse.CustomArrayWarehouse;

public class CustomArrayObserverImp implements CustomArrayObserver {
    private final CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
    @Override
    public void update(CustomArray array) throws ArrayFormatException{
        CustomArrayService service = new StreamCustomArrayServiceImpl();

        int min = service.findMin(array);
        int max = service.findMax(array);
        double avg = service.calculateAverage(array);
        int sum = service.calculateSum(array);

        CustomArrayParameters parameters = new CustomArrayParameters(min, max, avg, sum);
        warehouse.put(array.getId(), parameters);
    }
}
