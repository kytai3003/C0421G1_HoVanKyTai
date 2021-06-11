package _07_Java_abstract_interface.exercise.interface_resizeable;

public class TestResizeable {
    public static void main(String[] args) {
        Shape []shape = new Shape[3];
        shape[0] = new Circle(2.5);
        shape[1] = new Rectangle(3.0,4.0);
        shape[2] = new Square(5.0);

        System.out.println("Pre-increased: ");
        for (Shape shapes: shape) {
            System.out.println("Old values: " + shapes);
        }

        System.out.println("After-increased: ");
        ((Circle)shape[0]).resize(Math.random() * 100);
        System.out.println("New values: " + shape[0]);
        System.out.println("New area: " + ((Circle)shape[0]).getArea());

        ((Rectangle)shape[1]).resize(Math.random() * 100);
        System.out.println("New value: " + shape[1]);
        System.out.println("New area: " + ((Rectangle)shape[1]).getArea());

        ((Square)shape[2]).resize(Math.random() * 100);
        System.out.println("New value: " + shape[2]);
        System.out.println("New area: " + ((Square)shape[2]).getArea());
    }
}
