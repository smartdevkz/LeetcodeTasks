package Medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/
public class Solution131 {
    List<List<String>> res = new ArrayList<List<String>>();

    public List<List<String>> partition(String s) {
        solve(0, s, new ArrayList<String>());
        return res;
    }

    void solve(int idx, String s, List<String> lst) {
        if (idx == s.length()) {
            res.add(lst);
        }
        for (int i = idx + 1; i <= s.length(); i++) {
            var str = s.substring(idx, i);
            if (isPolindrome(str)) {
                var newLst = new ArrayList<>(lst);
                newLst.add(str);
                solve(i, s, newLst);
            }
        }
    }

    boolean isPolindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var app = new Solution131();
        var res = app.partition("aab");
        for (var items : res) {
            for (var c : items) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }


}
