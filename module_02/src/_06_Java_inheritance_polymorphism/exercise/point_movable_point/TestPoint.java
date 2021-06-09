package _06_Java_inheritance_polymorphism.exercise.point_movable_point;

import java.util.Arrays;

public class TestPoint {
    public static void main(String[] args) {
        Point point1 = new Point();
        System.out.println(point1);

        Point point2 = new Point(5.0f,6.0f);
        System.out.println(point2);

        Point point3 = new Point();
        point3.setXY(7.0f,6.0f);
        System.out.println(Arrays.toString(point3.getXY()));
    }
}
