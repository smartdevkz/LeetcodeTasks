package Medium;

//https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/
public class Solution1884 {

    public static void main(String[] args) {
        var app = new Solution1884();
        System.out.println(app.twoEggDrop(1));
    }

    static int[] dp = new int[1001];

    public int twoEggDrop(int n) {
        if (dp[n] == 0)
            for (int i = 1; i <= n; ++i)
                dp[n] = Math.min(dp[n] == 0 ? n : dp[n], 1 + Math.max(i - 1, twoEggDrop(n - i)));
        return dp[n];
    }
}
