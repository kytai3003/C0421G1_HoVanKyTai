package _06_Java_inheritance_polymorphism.exercise.circle_cylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder1 = new Cylinder();
        System.out.println(cylinder1);

        Cylinder cylinder2 = new Cylinder(2.0,"blue", 5.5);
        System.out.println(cylinder2);
        System.out.println(cylinder2.getVolume());
    }
}
