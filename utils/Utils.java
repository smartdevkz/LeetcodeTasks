package utils;

import java.util.Collection;

public class Utils {
    public static void display(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
    }

    public static void printArray(Collection<Integer> arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
    }

    public static void print(Object obj){
        System.out.println(obj.toString());
    }
}
