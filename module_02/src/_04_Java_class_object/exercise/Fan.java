package _04_Java_class_object.exercise;

public class Fan {
    private int speed = 1;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    private final int SLOW() {
        return this.speed = 1;
    }

    private final int MEDIUM() {
        return this.speed = 2;
    }

    private final int FAST() {
        return this.speed = 3;
    }

    public Fan() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (isOn()) {
            return "Fan is on {" +
                    "speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        } else {
            return "Fan is off {" +
                    "radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        Fan newFan1 = new Fan(3, true, 10, "yellow");
        newFan1.MEDIUM();
        String fan1 = newFan1.toString();
        System.out.println(fan1);

        Fan newFan2 = new Fan(2, false, 5, "blue");
        String fan2 = newFan2.toString();
        System.out.println(fan2);
    }
}