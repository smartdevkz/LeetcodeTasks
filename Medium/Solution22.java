package Medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        var items = solve(n * 2);
        var iter = items.iterator();
        while (iter.hasNext()) {
            var s = iter.next();
            if (!isValid(s)) {
                iter.remove();
            }
        }
        return items;
    }

    public List<String> solve(int n) {
        if (n == 1) {
            return List.of("(");
        }
        var next = solve(n - 1);
        List<String> res = new ArrayList<>();

        for (var s : List.of("(", ")")) {
            for (var item : next) {
                res.add(item + s);
            }
        }
        return res;
    }

    boolean isValid(String s) {
        if (s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(')
            return false;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            k += s.charAt(i) == '(' ? 1 : -1;
            if (k < 0)
                return false;
            if (k > s.length() / 2)
                return false;
        }
        return k == 0;
    }
}
