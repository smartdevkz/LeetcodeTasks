package Easy;

import java.util.HashMap;

//1941. Check if All Characters Have Equal Number of Occurrences
public class Solution1941 {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            int count = hm.containsKey(ch) ? hm.get(ch) : 0;
            hm.put(ch, count + 1);
        }

        int count = hm.get(s.charAt(0));
        for (var key : hm.keySet()) {
            if (count != hm.get(key)) {
                return false;
            }
        }
        return true;
    }
}
