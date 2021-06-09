package _06_Java_inheritance_polymorphism.exercise.point_2D_3D;

import java.util.Arrays;

public class TestPoint2D {
    public static void main(String[] args) {
        Point2D point1 = new Point2D();
        System.out.println(point1);
        System.out.println(Arrays.toString(point1.getXY()));

        Point2D point2 = new Point2D(3.0f,4.5f);
        System.out.println(point2);
        System.out.println(Arrays.toString(point2.getXY()));

        Point2D point3 = new Point2D();
        point3.setXY(1.5f,2.0f);
        System.out.println(point3);
        System.out.println(Arrays.toString(point3.getXY()));
    }
}
