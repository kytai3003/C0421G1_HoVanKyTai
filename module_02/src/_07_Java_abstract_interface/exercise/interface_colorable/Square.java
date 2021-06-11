package _07_Java_abstract_interface.exercise.interface_colorable;

public class Square extends Shape implements Colorable {
    double size = 1.0;

    public Square() {
    }

    public Square(double side) {
        this.size = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.size = side;
    }

    public double getSide() {
        return this.size;
    }

    public double getArea() {
        return this.size * this.size;
    }

    public void setSide(double side) {
        this.size = side;
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}
