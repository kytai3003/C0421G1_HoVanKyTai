package _10_Java_DSA_list.exercise.MyList;

import java.util.Arrays;

public class MyList<E> {
    int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public MyList(Object[] elements) {
        this.elements = elements;
    }

    public MyList(int size, Object[] elements) {
        this.size = size;
        this.elements = elements;
    }

    public void add (int index, E element) {
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            int bigSize = size * 2 + 1;
            elements = Arrays.copyOf(elements, bigSize);
        }
    }

    public void clear() {
        elements = (Object[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public Object get(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        }
        return null;
    }

    public boolean add(Object e, int index) {
        if (index >= 0 && index <= size) {
            size += 1;
            ensureCapacity();
            for (int i = size - 2; i >= index; i--) {
                elements[i + 1] = elements[i];
            }
            elements[index] = e;
            return true;
        }
        return false;
    }

    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object e) {
        for (Object x : elements) {
            if (e.equals(x)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public MyList clone() {
        MyList<Object> clone = new MyList<>(elements.length);
        for (Object x : elements) {
            clone.add(x);
        }
        return clone;
    }

    public void add(Object e) {
        size += 1;
        ensureCapacity();
        elements[size - 1] = e;
    }

    public Object remove(int index) {
        Object e = elements[index];
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size - 1] = null;
            size--;
        }
        return e;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
