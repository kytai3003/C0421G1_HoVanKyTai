package _10_Java_DSA.exercise.MyList;

public class TestMyList {
    public static void main(String[] args) {
        MyList<Character> character = new MyList<>();

        //Add
        character.add("a");
        character.add("f");
        character.add("c");
        character.add("k");
        character.add("2");
        character.add("8");
        System.out.println(character.toString());

        //Remove
        character.remove(3);
        System.out.println(character.toString());

        //Contains
        System.out.println(character.contains("p"));

        //IndexOf
        System.out.println(character.indexOf("8"));

        //Clear
        character.clear();
        System.out.println(character.toString());
    }
}
