package _11_Java_stack_queue.exercise.circular_linked_list;

public class Solution {
    static class Node {
        int data;
        Node next;
    }

    static class Queue {
        Node front;
        Node rear;
    }

    static void enQueue(Queue q, int value) {
        Node temp = new Node();
        temp.data = value;
        if (q.front ==  null) {
            q.front = q.rear = temp;
        } else {
            q.rear.next = temp;
        }
        q.rear = temp;
        q.rear.next = q.front;
    }

    static int deQueue(Queue q) {
        if (q.front == null) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int value;
        if (q.front == q.rear) {
            value = q.front.data;
            q.front = null;
            q.rear = null;
        } else {
            Node temp = q.front;
            value = temp.data;
            q.front = q.front.next;
            q.rear.next= q.front;
        }
        return value ;
    }

    static void displayQueue(Queue q) {
        Node temp = q.front;
        System.out.println("Elements in Circular Queue are: ");
        while (temp.next != q.front) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.front = q.rear = null;

        enQueue(q,14);
        enQueue(q,22);
        enQueue(q,6);

        System.out.println("Deleted value = " + deQueue(q));
        System.out.println("Deleted value = " + deQueue(q));

        displayQueue(q);

        enQueue(q,9);
        enQueue(q,20);
        displayQueue(q);
    }
}
