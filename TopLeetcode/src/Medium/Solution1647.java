package Medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
public class Solution1647 {
    public int minDeletions(String s) {
        int sum = 0;
        var hm = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            var count = hm.getOrDefault(c, 0);
            hm.put(c, count + 1);
        }

        List<Integer> lst = hm.values().stream().sorted(Collections.reverseOrder()).toList();
        int prev = lst.get(0);
        for (int i = 1; i < lst.size(); i++) {
            if (prev == 0) {
                sum += lst.get(i);
                continue;
            }
            if (lst.get(i) >= prev) {
                int newVal = prev - 1;
                sum += lst.get(i) - newVal;
                prev = newVal;
            } else {
                prev = lst.get(i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        var app = new Solution1647();
        System.out.println(app.minDeletions("abc"));
    }
}
