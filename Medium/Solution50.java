package Medium;

//https://leetcode.com/problems/powx-n/
public class Solution50 {
    public static void main(String[] args) {
        var app = new Solution50();
        System.out.println(app.myPow2(2.00000, -2147483648));
    }

    public double myPow(double x, int n) {
        if (n == -2147476672) {
            System.out.println("n=" + n);
        }
        if (x == 1 || n == 0)
            return 1;
        if (n < 0)
            return ((double) 1 / myPow(x, ++n));
        return x * myPow(x, --n);
    }

    public double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++)
            ans = ans * x;
        return ans;
    }

}
