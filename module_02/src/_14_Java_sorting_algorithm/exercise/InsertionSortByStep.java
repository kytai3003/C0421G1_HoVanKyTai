package _14_Java_sorting_algorithm.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortByStep {
    static Scanner sc = new Scanner(System.in);
    public static void insertionSortByStep(int[] array) {
        int pos, x;
        for(int i = 1; i < array.length; i++){
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                System.out.println("Assign " + array[pos - 1] + " to " + array[pos]);
                array[pos] = array[pos-1];
                pos--;
            }
            System.out.println("Assign " + x + " to " + array[pos]);
            array[pos] = x;
            System.out.println("Array after the " + i + "' sort: ");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + "\t");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        System.out.println("Input array size: ");
        int size = sc.nextInt();
        int[] intArr = new int[size];
        for (int i = 0; i < intArr.length; i++) {
            System.out.println("Input element " + (i+1));
            intArr[i] = sc.nextInt();
        }
        for (Integer l: intArr) {
            System.out.print(l + " ");
        }
        System.out.println();

        insertionSortByStep(intArr);
        System.out.println("Sorted: " + Arrays.toString(intArr));
    }
}
