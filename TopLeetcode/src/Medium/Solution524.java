package Medium;

import java.util.List;

//https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
public class Solution524 {
    public String findLongestWord(String s, List<String> dictionary) {

        int maxSize = 0;
        String result = "";

        for (var word : dictionary) {

            if (word.length() < maxSize) continue;

            if (s == word) return word;

            int i = 0, j = 0;
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) == word.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }

            if (j == word.length()) {

                if (maxSize < word.length() || ((maxSize == word.length() && word.compareTo(result) < 0))) {
                    maxSize = word.length();
                    result = word;
                }

            }

        }

        return result;
    }
}
