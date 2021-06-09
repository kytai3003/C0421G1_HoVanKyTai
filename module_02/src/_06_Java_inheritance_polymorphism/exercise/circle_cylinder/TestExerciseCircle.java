package _06_Java_inheritance_polymorphism.exercise.circle_cylinder;

public class TestExerciseCircle {
    public static void main(String[] args) {
        ExerciseCircle circle1 = new ExerciseCircle();
        System.out.println(circle1);

        ExerciseCircle circle2 = new ExerciseCircle(2.0, "black");
        System.out.println(circle2);
    }
}
