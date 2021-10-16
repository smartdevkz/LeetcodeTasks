package Easy;

import java.util.HashSet;

//804. Unique Morse Code Words
public class Solution804 {
    public static void main(String[] args) {
        var str = "AZaz";// 97-122
        for (int i = 0; i < str.length(); i++) {
            System.out.println((int) str.charAt(i));
        }
    }

    public int uniqueMorseRepresentations(String[] words) {
        if (words.length == 1)
            return 1;
        var morze = getMorze();
        HashSet<String> hs = new HashSet<>();
        for (String str : words) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                builder.append(morze[str.charAt(i)-'a']);
            }
            hs.add(builder.toString());
        }
        return hs.size();
    }

    String[] getMorze() {
        return new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
    }
}
