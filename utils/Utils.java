package utils;

public class Utils {
    public static void display(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
    }

    public static void printArray(int[] arr) {
        display(arr);
    }
}
