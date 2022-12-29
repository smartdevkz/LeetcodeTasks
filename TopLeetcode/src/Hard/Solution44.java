package Hard;

//https://leetcode.com/problems/wildcard-matching/
public class Solution44 {
    public boolean isMatch2(String s, String p) {
        System.out.println("s=" + s + ", p=" + p);
        int i = 0;
        int j = 0;
        while (i < s.length() || j < p.length()) {
            var curr = i < s.length() ? s.charAt(i) : ' ';
            if (j >= p.length()) return false;
            var pc = p.charAt(j);
            System.out.println("s=" + curr + ", p=" + p);
            if (pc != '*') {
                if (pc == '?' || pc == curr) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            } else {
                if (j == p.length() - 1) {
                    return true;
                }
                String p2 = p.substring(j + 1);
                String s2 = s.substring(i);
                if (isMatch(s2, p2)) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return i >= s.length() && j >= p.length();
    }

    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();

        var dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = p.charAt(i - 1) == '*' ? dp[i - 1][0] : false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
                } else {
                    if (p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        printArr(dp);
        return dp[n][m];
    }

    public static void main(String[] args) {
        var app = new Solution44();
        //var res = app.isMatch("acdcb", "a*c?b");
        //var res = app.isMatch("acdcb", "a*c??b");
        //var res = app.isMatch("", "*****");
        //var res = app.isMatch("", "*****");
        //var res = app.isMatch("", "*a**");
        //var res = app.isMatch("aa", "*");
        var res = app.isMatch("", "***");
        System.out.println(res);
    }

    void printArr(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] ? "1 " : "0 ");
            }
            System.out.println("");
        }
    }
}


