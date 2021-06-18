package _10_Java_DSA_list.practise.MyLinkedList;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.add(2, 15);

        ll.add(4,9);
        ll.add(4,9);
        ll.printList();
    }
}
