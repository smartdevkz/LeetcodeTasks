package Easy.DynamicProgramming;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        System.out.println(3 & 2);
    }

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        Arrays.fill(result, 0);
        for (int i = 1; i <= n; i++) {
            int val = i;
            int count = 0;
            while (val > 0) {
                int isOne = val & 1;
                count += isOne;
                val = val >>> 1;
            }
            result[i] = count;
        }
        return result;
    }

    static void bin(int n) {
        if (n > 1)
            bin(n / 2);
        System.out.print(n % 2);
    }
}
