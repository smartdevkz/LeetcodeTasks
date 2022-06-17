package Medium;

//https://leetcode.com/problems/palindromic-substrings/
public class Solution647 {
    public static void main(String[] args) {
        var app = new Solution647();
        System.out.println(app.countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                var substr = s.substring(i, j);
                if (isPalindromic(substr)) {
                    System.out.println(substr);
                    count++;
                }
            }
        }
        return count;
    }

    boolean isPalindromic(String s) {
        if (s.length() == 1)
            return true;
        int i = 0;
        while (i < s.length() - i - 1) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
