package Medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
public class Solution1415 {

    List<String> results = new ArrayList<>();

    public String getHappyString(int n, int k) {

        backtracking(new StringBuilder(), n, k, List.of('a','b','c'));
        return results.size() >= k ? results.get(k - 1) : "";
    }

    private void backtracking(StringBuilder sb, int n, int k, List<Character> lst) {

        if(sb.length() == n) {
            results.add(sb.toString());
            return;
        }

        Character prev = sb.length() > 0 ? sb.charAt(sb.length() - 1): 'd';

        for (var current: lst) {

            if (current == prev) continue;

            sb.append(current);

            backtracking(sb, n, k, lst);

            sb.deleteCharAt(sb.length() - 1);

        }

    }

    public static void main(String[] args) {
        var app = new Solution1415();
        app.getHappyString(2,2);
    }
}
