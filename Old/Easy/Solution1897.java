package Easy;

import java.util.HashMap;

//https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
public class Solution1897 {
    public boolean makeEqual(String[] words) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (var s : words) {
            for (var ch : s.toCharArray()) {
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            }
        }

        for (var k : hm.keySet()) {
            if (hm.get(k) % words.length != 0)
                return false;
        }
        return true;
    }
}
