package by.dulskij.taskarray.comporator;

import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.service.CustomArrayService;
import by.dulskij.taskarray.service.impl.StreamCustomArrayServiceImpl;

import java.util.Comparator;

public enum CustomArrayComparator implements Comparator<CustomArray> {
    ID {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            return Integer.compare(o1.getId(), o2.getId());
        }
    },
    LENGTH {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            return Integer.compare(o1.getArray().length, o2.getArray().length);
        }
    },
    MIN {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            CustomArrayService service = new StreamCustomArrayServiceImpl();
            try {
                return Integer.compare(service.findMin(o1), service.findMin(o2));
            } catch (ArrayFormatException e) {
                throw new RuntimeException(e);
            }
        }
    };
}
