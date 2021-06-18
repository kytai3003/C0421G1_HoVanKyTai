package _10_Java_DSA_list.practise.MyList;

public class TestMyList {
    public static void main(String[] args) {
        MyList<Integer> intList = new MyList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        System.out.println("element 4: "+intList.get(4));
        System.out.println("element 1: "+intList.get(1));
        System.out.println("element 2: "+intList.get(2));

        intList.get(-1);
        System.out.println("element -1: " + intList.get(-1));
    }
}
