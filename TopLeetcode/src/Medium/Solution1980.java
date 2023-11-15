package Medium;

import java.util.HashSet;

//https://leetcode.com/problems/find-unique-binary-string/
public class Solution1980 {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        HashSet<String> hs = new HashSet<>();

        backtracking(hs, n, new StringBuilder());

        System.out.println(hs);

        return "";

    }

    void backtracking(HashSet<String> hs, int n, StringBuilder sb) {

        if (sb.length() == n) {
            hs.add(sb.toString());
            return;

        }

        sb.append('0');
        backtracking(hs, n, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append('1');
        backtracking(hs, n, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public void run() {
        System.out.println("ura");
        var hs = new HashSet<String>();

        backtracking(hs, 2, new StringBuilder());

    }

    public static void main(String[] args) {
        var app = new Solution1980();
        app.run();
    }
}
