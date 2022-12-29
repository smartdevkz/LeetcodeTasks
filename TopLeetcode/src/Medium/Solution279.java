package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/perfect-squares/
public class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        var hs = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            var sq = i * i;
            if (sq <= n) {
                hs.add(sq);
            } else {
                break;
            }
        }
        return solve(n, hs, dp);
    }

    int solve(int n, List<Integer> lst, int[] dp) {
        if (n < 4) return n;
        if (dp[n] > 0) return dp[n];
        int min = Integer.MAX_VALUE;
        for (int sq : lst) {
            if (sq <= n) {
                int count = solve(n - sq, lst, dp) + 1;
                min = Math.min(min, count);
            }
        }
        dp[n] = min;
        return min;
    }

    public static void main(String[] args) {
        var app = new Solution279();
        System.out.println(app.numSquares(49));
    }
}
