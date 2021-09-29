package Easy.DynamicProgramming;

public class Solution1646 {
    public static void main(String[] args) {
        var app = new Solution1646();
        int res = app.getMaximumGenerated(0);
        System.out.println(res);
    }

    int[] dp;

    public int getMaximumGenerated(int n) {
        dp = new int[n+1];
        int max = 0;
        for (int i = 0; i <= n; i++) {
            int c = solve(i);
            if (c > max)
                max = c;
        }
        return max;
    }

    int solve(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (dp[n] > 0)
            return dp[n];
        int val = n % 2 == 0 ? solve(n / 2) : solve((n - 1) / 2) + solve((n + 1) / 2);
        dp[n] = val;
        return val;
    }
}
