package Medium;

//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
public class Solution712 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            dp[i][n] = dp[i + 1][n] + s1.codePointAt(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            dp[m][i] = dp[m][i + 1] + s2.codePointAt(i);
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + s1.codePointAt(i), dp[i][j + 1] + s2.codePointAt(j));
                }
            }
        }

        return dp[0][0];
    }
}
