package module6;

import java.util.Arrays;
import java.util.Objects;

/**
 * My own ArrayList implementation
 *
 * @param <T> type of data in ArrayList
 */
public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size = 0;


    public MyArrayList() {
        try {
            this.array = (T[]) new Object[DEFAULT_CAPACITY];
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }


    public boolean add(T value) {

        if (array[array.length - 1] != null) {
            array = Arrays.copyOf(array, array.length * 2);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = value;
                size = size + 1;
                return true;
            }
        }

        return false;
    }


    public T remove(int index) {
        Objects.checkIndex(index, size);

        T oldValue = array[index];

        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(array, index + 1, array, index,
                    numMoved);
        size--;
        return oldValue;
    }


    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }


    public int size() {
        return size;
    }


    public T get(int index) {
        return array[index];
    }

    /**
     * Print all elements in list
     */
    public void printList() {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ",");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println("]");
    }
}
