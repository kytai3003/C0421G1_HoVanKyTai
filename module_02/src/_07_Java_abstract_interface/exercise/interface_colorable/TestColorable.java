package _07_Java_abstract_interface.exercise.interface_colorable;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(5.5);
        System.out.println("Area: " + ((Circle) shapes[0]).getArea());

        shapes[1] = new Square(3.5);
        System.out.println("Area: " + ((Square) shapes[1]).getArea());

        shapes[2] = new Circle();
        System.out.println("Area: " + ((Circle) shapes[2]).getArea());

        shapes[3] = new Square();
        System.out.println("Area: " + ((Square) shapes[3]).getArea());

        for (int i = 0; i < shapes.length; i++){
            if (shapes[i] instanceof Colorable) {
                System.out.println("Shape " + (i+1) + " is a square.");
                ((Colorable)shapes[i]).howToColor();
            }
        }
    }
}