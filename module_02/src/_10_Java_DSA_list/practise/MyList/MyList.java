package _10_Java_DSA_list.practise.MyList;

import java.util.Arrays;

public class MyList<E> {
    int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapa() {
        int newSize = this.elements.length * 2;
        this.elements = Arrays.copyOf(this.elements, newSize);
    }

    public void add(E e) {
        if (this.size == this.elements.length) {
            ensureCapa();
        }
        this.elements[this.size++] = e;
    }

    public E get(int i) {
        if (i>= this.size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) this.elements[i];
    }
}
