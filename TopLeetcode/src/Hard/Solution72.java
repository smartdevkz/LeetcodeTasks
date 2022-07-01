package Hard;

public class Solution72 {

    public static void main(String[] args) {
        var app = new Solution72();
        var res = app.minDistance("zoologicoarchaeologist", "zoogeologist");
        System.out.println(res);
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n == 0) return m;
        if (m == 0) return n;

        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int cost = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + cost, dp[i - 1][j] + 1);
            }
        }

        return dp[n][m];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
