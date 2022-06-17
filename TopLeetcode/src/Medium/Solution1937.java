package Medium;

public class Solution1937 {
    public static void main(String[] args) {
        var app = new Solution1937();
        var arr = new int[][]{
                {5, 8, 6, 9, 2}, {3, 2, 2, 6, 0}, {2, 5, 6, 10, 3}, {4, 2, 1, 6, 0}, {7, 3, 3, 7, 5}, {4, 3, 3, 0, 10}, {3, 6, 5, 4, 1}, {4, 5, 10, 8, 6}, {10, 8, 5, 0, 1}, {4, 2, 9, 4, 0}
        };
        var res = app.maxPoints(arr);
        System.out.println(res);
    }

    public long maxPoints(int[][] points) {
        long ans = 0;
        int m = points.length, n = points[0].length;
        long[] dp = new long[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j] += points[i][j];
            }
            for (int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            }
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j + 1] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
