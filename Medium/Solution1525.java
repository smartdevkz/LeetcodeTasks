package Medium;

import java.util.HashSet;

//https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
public class Solution1525 {
    public static void main(String[] args) {
        var app = new Solution1525();
        var res = app.numSplits("aaaaa");
        System.out.println(res);
    }

    public int numSplits(String s) {
        if (s.length() < 2)
            return 0;
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i, s.length());
            System.out.println(s1 + " : " + s2);
            if (isGood(s1, s2))
                count++;
        }
        return count;
    }

    boolean isGood(String s1, String s2) {
        var hs1 = new HashSet<Character>();
        for (var c : s1.toCharArray()) {
            hs1.add(c);
        }
        var hs2 = new HashSet<Character>();
        for (var c : s2.toCharArray()) {
            hs2.add(c);
        }
        return hs1.size() == hs2.size();
    }
}
