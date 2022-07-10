package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution91 {

    Map<Integer, Integer> hm = new HashMap<>();

    public int numDecodings(String s) {
        return solve(0, s);
    }

    int solve(int idx, String s) {
        if (idx == s.length()) return 1;
        if (s.charAt(idx) == '0') return 0;
        if (idx == s.length() - 1) return 1;
        if (hm.containsKey(idx)) return hm.get(idx);

        int res = solve(idx + 1, s);
        if (idx + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(idx, idx + 2));
            if (twoDigit <= 26) {
                res += solve(idx + 2, s);
            }
        }
        hm.put(idx, res);
        return res;
    }

    public int numDecodings2(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    public int numDecodings3(String s) {
        int twoBack = 1;
        int oneBack = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < s.length() + 1; i++) {
            int next = 0;
            if (s.charAt(i - 1) != '0') {
                next = oneBack;
            }

            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                next += twoBack;
            }

            twoBack = oneBack;
            oneBack = next;
        }

        return oneBack;
    }

    public static void main(String[] args) {
        var app = new Solution91();
        String s = "2125";
        var res = app.numDecodings(s);
        System.out.println(res);
    }
}
