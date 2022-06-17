package Easy;

import java.util.HashSet;

import utils.Utils;

//1763. Longest Nice Substring
public class Solution1763 {
    public static void main(String[] args) {
        var app = new Solution1763();
        Utils.print(app.longestNiceSubstring("Bb"));
    }

    public String longestNiceSubstring(String s) {
        if (s.length() < 2)
            return "";
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(Character.toLowerCase(s.charAt(i))) && set.contains(Character.toUpperCase(s.charAt(i))))
                continue;
            var substr1 = longestNiceSubstring(s.substring(0, i));
            var substr2 = longestNiceSubstring(s.substring(i + 1));
            return substr1.length() > substr2.length() ? substr1 : substr2;
        }

        return s;
    }
}
