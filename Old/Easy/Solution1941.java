package Easy;

import java.util.HashMap;

//1941. Check if All Characters Have Equal Number of Occurrences
public class Solution1941 {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];

        for (var c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int prev = freq[s.charAt(0) - 'a'];
        for (int i : freq) {
            if (i > 0 && i != prev)
                return false;
        }

        return true;
    }
}
