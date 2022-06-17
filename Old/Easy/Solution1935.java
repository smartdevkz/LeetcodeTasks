package Easy;

import java.util.HashSet;

//1935. Maximum Number of Words You Can Type
public class Solution1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        if (brokenLetters.length() == 0)
            return text.split(" ").length;

        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            hs.add(brokenLetters.charAt(i));
        }
        int k = text.split(" ").length;
        for (var item : text.split(" ")) {
            for (var letter : item.toCharArray()) {
                if (hs.contains(letter)) {
                    k--;
                    break;
                }
            }
        }
        return k;
    }
}
