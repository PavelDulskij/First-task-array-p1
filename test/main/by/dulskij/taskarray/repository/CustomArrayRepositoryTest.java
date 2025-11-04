package by.dulskij.taskarray.repository;

import by.dulskij.taskarray.comporator.CustomArrayComparator;
import by.dulskij.taskarray.entity.CustomArray;
import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.repository.CustomArrayRepository;
import by.dulskij.taskarray.repository.impl.IdCustomArraySpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomArrayRepositoryTest {

    @Test
    void whenAddArrayThenArrayShouldBePresent() throws ArrayFormatException {
        CustomArrayRepository repository = CustomArrayRepository.getInstance();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3})
                .setId(1)
                .build();

        repository.addArray(array);
        assertEquals(1, repository.query(new IdCustomArraySpecification(1)).size(),
                "Array should be present in the repository");
    }

    @Test
    void whenRemoveArrayThenArrayShouldNotBePresent() throws ArrayFormatException {
        CustomArrayRepository repository = CustomArrayRepository.getInstance();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3})
                .setId(1)
                .build();

        repository.addArray(array);
        repository.removeArray(array);
        assertEquals(0, repository.query(new IdCustomArraySpecification(1)).size(),
                "Array should be removed from the repository");
    }

    @Test
    void whenSortArrayByIdThenArraysShouldBeSorted() throws ArrayFormatException {
        CustomArrayRepository repository = CustomArrayRepository.getInstance();
        CustomArray array1 = new CustomArray.Builder()
                .setArray(new int[]{1, 2})
                .setId(2)
                .build();
        CustomArray array2 = new CustomArray.Builder()
                .setArray(new int[]{3, 4})
                .setId(1)
                .build();

        repository.addArray(array1);
        repository.addArray(array2);
        repository.sortArray(CustomArrayComparator.ID);

        assertEquals(1, repository.query(new IdCustomArraySpecification(1)).get(0).getId(),
                "First array ID should be 1");
        assertEquals(2, repository.query(new IdCustomArraySpecification(2)).get(0).getId(),
                "Second array ID should be 2");
    }

    @Test
    void whenQueryBySpecificationThenReturnMatchingArrays() throws ArrayFormatException {
        CustomArrayRepository repository = CustomArrayRepository.getInstance();
        CustomArray array1 = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3})
                .setId(1)
                .build();
        CustomArray array2 = new CustomArray.Builder()
                .setArray(new int[]{4, 5, 6})
                .setId(2)
                .build();

        repository.addArray(array1);
        repository.addArray(array2);

        assertEquals(1, repository.query(new IdCustomArraySpecification(1)).size(),
                "Should return 1 matching array for ID 1");
        assertEquals(1, repository.query(new IdCustomArraySpecification(2)).size(),
                "Should return 1 matching array for ID 2");
    }

    @Test
    void whenQueryWithNoMatchingSpecificationThenReturnEmptyList() throws ArrayFormatException {
        CustomArrayRepository repository = CustomArrayRepository.getInstance();
        CustomArray array = new CustomArray.Builder()
                .setArray(new int[]{1, 2, 3})
                .setId(1)
                .build();

        repository.addArray(array);
        assertEquals(0, repository.query(new IdCustomArraySpecification(2)).size(),
                "Should return an empty list for non-matching ID");
    }
}