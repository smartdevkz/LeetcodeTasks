package Hard;

//https://leetcode.com/problems/wildcard-matching/
public class Solution44 {
    public boolean isMatch(String s, String p) {
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

    public static void main(String[] args) {
        var app = new Solution44();
        var res = app.isMatch("acdcb", "a*c?b");
        //var res = app.isMatch("", "*****");
        System.out.println(res);
    }
}


