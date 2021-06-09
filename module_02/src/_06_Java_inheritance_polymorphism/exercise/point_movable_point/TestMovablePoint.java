package _06_Java_inheritance_polymorphism.exercise.point_movable_point;

public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint move1 = new MovablePoint();
        System.out.println(move1);

        MovablePoint move2 = new MovablePoint(2.5f,1.0f,5.0f,4.0f);
        System.out.println(move2);
        move2.move();
        System.out.println(move2);

        MovablePoint move3 = new MovablePoint();
        move3.setSpeed(5.0f,10.0f);
        System.out.println(move3);
        move3.move();
        System.out.println(move3);

    }
}
