package Easy;

import java.util.HashMap;

//953. Verifying an Alien Dictionary
public class Solution953 {
    public boolean isAlienSorted(String[] words, String order) {
        var alphabet = getAlphabet(order);
        boolean isSorted = true;
        for (int i = 0; i < words.length - 1; i++) {
            isSorted = isSorted && isLessOrEqual(words[i], words[i + 1], alphabet);
        }
        return isSorted;
    }

    boolean isLessOrEqual(String a, String b, HashMap<Character, Integer> alphabet) {
        int i = 0;
        while (i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        if (i >= b.length() && i < a.length())
            return false;
        if (i >= a.length())
            return true;
        return alphabet.get(a.charAt(i)) < alphabet.get(b.charAt(i));
    }

    HashMap<Character, Integer> getAlphabet(String order) {
        HashMap<Character, Integer> res = new HashMap<>();
        int i = 0;
        for (var ch : order.toCharArray()) {
            res.put(ch, i);
            i++;
        }
        return res;
    }

}

/*
Runtime: 1 ms, faster than 61.48% of Java online submissions for Verifying an Alien Dictionary.
Memory Usage: 38.6 MB, less than 84.41% of Java online submissions for Verifying an Alien Dictionary.
*/
