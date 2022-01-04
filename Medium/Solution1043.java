package Medium;

//https://leetcode.com/problems/partition-array-for-maximum-sum/
public class Solution1043 {
    public static void main(String[] args) {
        var arr = new int[] { 1, 2, 3 };
        var app = new Solution1043();
        app.maxSumAfterPartitioning(arr, 2);
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int currMax = 0, best = 0;
            for (int r = 1; r <= k && i - r >= 0; r++) {
                currMax = Math.max(currMax, arr[i - r]);
                best = Math.max(best, dp[i - r] + currMax * r);
            }
            dp[i] = best;
        }

        return dp[n];
    }

}
