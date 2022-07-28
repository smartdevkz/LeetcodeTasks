package Medium;

public class Solution29 {

    int[] powers = new int[32];

    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negatives = 0;
        if (dividend < 0) {
            negatives++;
            dividend = -dividend;
        }
        if (divisor < 0) {
            negatives++;
            divisor = -divisor;
        }

        powers[0] = divisor;
        for (int i = 1; i < 32; i++) {
            powers[i] = powers[i - 1] + powers[i - 1];
        }

        int quotient = 0;
        while (dividend >= divisor) {
            int x = 0;
            int i = 1;
            while (powers[i] <= dividend) {
                i++;
            }
            x = powers[i - 1];
            quotient += i;
            dividend = dividend - x;
        }

        if (negatives == 1) {
            return -quotient;
        }
        return quotient;
    }

    int getQuotient(int dividend, int divisor) {
        if (dividend < divisor) return 0;
        for (int i = 1; i < 32; i++) {
            if (powers[i] > dividend) return powers[i - 1];
        }
        return 0;
    }


    public static void main(String[] args) {
        var app = new Solution29();
        var res = app.divide(12, 3);
        System.out.println(res);
    }
}
