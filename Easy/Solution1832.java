package Easy;

import java.util.HashSet;

//1832. Check if the Sentence Is Pangram
public class Solution1832 {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            hs.add(sentence.charAt(i));
            if (hs.size() == 26)
                return true;
        }
        return false;
    }
}
