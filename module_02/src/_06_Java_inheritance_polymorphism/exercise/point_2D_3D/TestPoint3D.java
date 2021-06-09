package _06_Java_inheritance_polymorphism.exercise.point_2D_3D;

import java.util.Arrays;

public class TestPoint3D {
    public static void main(String[] args) {
        Point3D point1 = new Point3D();
        System.out.println(point1);

        Point3D point2 = new Point3D(3.5f,2.0f,4.0f);
        System.out.println(point2);
        System.out.println(Arrays.toString(point2.getXYZ()));

        Point3D point3 = new Point3D();
        point3.setXYZ(1.0f,1.0f,1.0f);
        System.out.println(Arrays.toString(point3.getXYZ()));
    }
}
