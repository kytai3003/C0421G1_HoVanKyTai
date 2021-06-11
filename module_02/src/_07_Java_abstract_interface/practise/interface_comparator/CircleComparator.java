package _07_Java_abstract_interface.practise.interface_comparator;


import _07_Java_abstract_interface.practise.interface_comparable.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) {
            return 1;
        }
        else if (c1.getRadius() < c2.getRadius()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}