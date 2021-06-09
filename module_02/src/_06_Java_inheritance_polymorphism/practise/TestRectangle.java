package _06_Java_inheritance_polymorphism.practise;

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        System.out.println(rect);

        rect = new Rectangle(2.3, 5.8);
        System.out.println(rect);

        rect = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rect);
    }
}
