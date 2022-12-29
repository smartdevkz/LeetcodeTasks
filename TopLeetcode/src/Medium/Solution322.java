package Medium;

//https://leetcode.com/problems/coin-change/
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        var dp = new Integer[amount + 1];
        var res = solve(coins, amount, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int solve(int[] coins, int n, Integer[] dp) {
        if (n < 0) return Integer.MAX_VALUE;
        if (n == 0) return 0;
        if (dp[n] != null) return dp[n];
        int best = Integer.MAX_VALUE;
        for (int c : coins) {
            best = Math.min(best, solve(coins, n - c, dp));
        }
        if (best != Integer.MAX_VALUE) best++;
        dp[n] = best;
        return best;
    }

    public static void main(String[] args) {
        var app = new Solution322();
        System.out.println(app.coinChange(new int[]{186, 419, 83, 408}, 6249));
        //System.out.println(app.coinChange(new int[]{1, 2, 5}, 100));
        //System.out.println(Integer.MAX_VALUE + 1);
    }
}
