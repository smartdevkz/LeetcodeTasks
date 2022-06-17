package Array;

public class PlusOneApp {
    public static void main(String[] args) {
        PlusOneApp app = new PlusOneApp();
        app.run();
    }

    void run(){
        int[] digits = new int[]{1,9,9};
        display(plusOne(digits));
    }

    public int[] plusOne(int[] digits) {
        int r = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + r > 9) {
                digits[i] = 0;
                r = 1;
            } else {
                digits[i] = digits[i] + r;
                r = 0;
            }
        }
        return r > 0 ? merge(r, digits) : digits;
    }

    int[] merge(int a, int[] digits) {
        int[] arr = new int[digits.length + 1];
        arr[0] = a;
        for (int i = 0; i < digits.length; i++) {
            arr[i + 1] = digits[i];
        }
        return arr;
    }

    void display(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}