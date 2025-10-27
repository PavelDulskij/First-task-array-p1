package by.dulskij.taskarray.entity;

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
}
