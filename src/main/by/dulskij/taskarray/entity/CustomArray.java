package by.dulskij.taskarray.entity;

import by.dulskij.taskarray.exception.ArrayFormatException;
import by.dulskij.taskarray.observer.CustomArrayObservable;
import by.dulskij.taskarray.observer.CustomArrayObserver;

import java.util.Arrays;

public class CustomArray implements CustomArrayObservable {
    private int[] array;
    private int id;
    private CustomArrayObserver observer;

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
    public void addObserver(CustomArrayObserver observer) throws ArrayFormatException {
        this.observer = observer;
    }

    @Override
    public void removeObserver(CustomArrayObserver observer) throws ArrayFormatException {
        this.observer = null;
    }

    @Override
    public void notifyObservers(CustomArrayObserver observer) throws ArrayFormatException {
        if (observer != null) {
            observer.update(this);
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
        final StringBuilder sb = new StringBuilder("CustomArray{");
        sb.append("array=");
        if (array == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < array.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(array[i]);
            sb.append(']');
        }
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}