package module6;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList<T> extends ArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    transient T[] elementData;


    public MyArrayList(T[] argument) {
        this.elementData = new T[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(T value) {

        if (elementData[elementData.length - 1] != null) {
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }

        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] == null) {
                elementData[i] = value;
                return true;
            }
        }

        return false;
    }

    public T remove(int index) {



        return null;
    }

    public void clear() {

    }

    public int size() {
        return 0;
    }

    public T get(int index) {

        return null;
    }
}
