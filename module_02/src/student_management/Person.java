package student_management;

public class Person implements Comparable<Person>{
    protected int id;
    protected String name;
    protected int age;
    protected String address;

    public Person() {
    }

    public Person(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void move() {
        System.out.println("Đi bộ");
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (getAge() > o.getAge()) {
            return 1;
        } else if (getAge() < o.getAge()) {
            return -1;
        } else if (getId() > o.getId()) {
            return 1;
        } else if (getId() < o.getId()) {
            return -1;
        } else {
            return 1;
        }
    }
}
