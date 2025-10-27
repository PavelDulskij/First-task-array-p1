package by.dulskij.taskarray.entity;

import java.util.Arrays;
import java.util.Objects;

public class CustomArray {
    private int[] array;
    private int id;

    public CustomArray(int[] array) {
        this.array = array.clone();
    }

    public CustomArray() {
        this.array = new int[10];
    }

    public CustomArray(int[] array, int length) {
        this.array = new int[length];
    }

    public int[] getArray() {
        return array;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return id == that.id && Objects.deepEquals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(array), id);
    }
}
