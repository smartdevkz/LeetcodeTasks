package Medium;

public class Solution2396 {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            var str = Integer.toString(n, i);
            if (!isPolindrom(str)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPolindrom(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) == str.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var app = new Solution2396();
        var res = app.isStrictlyPalindromic(9);
        System.out.println(res);
    }
}
