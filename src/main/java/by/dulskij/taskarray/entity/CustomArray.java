package by.dulskij.taskarray.entity;

import by.dulskij.taskarray.exception.ArrayFormatException;

import java.util.Arrays;
import java.util.Observable;

public class CustomArray {
    private int[] array;
    private int id;

    private CustomArray(int[] array) {
        this.array = array.clone();
    }

    public int[] getArray() {
        return array;
    }

    public int getId() {
        return id;
    }

    public static class Builder {
        private int[] array;
        private int id;

        public Builder setArray(int[] array) {
            this.array = array != null ? array.clone() : new int[0];
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public CustomArray build() throws ArrayFormatException {
            CustomArray customArray = new CustomArray(array);
            customArray.id = this.id;
            return customArray;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        CustomArray that = (CustomArray) o;
        return id == that.id && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(array);
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "CustomArray{" +
                "array=" + Arrays.toString(array) +
                ", id=" + id +
                '}';
    }
}