package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//500. Keyboard Row
public class Solution500 {
    public String[] findWords(String[] words) {
        HashMap<Character, Integer> hm = new HashMap<>();
        fillMap(hm, "qwertyuiopQWERTYUIOP", 1);
        fillMap(hm, "asdfghjklASDFGHJKL", 2);
        fillMap(hm, "zxcvbnmZXCVBNM", 3);

        List<String> result = new ArrayList<>();
        for (var item : words) {
            int k = hm.get(item.charAt(0));
            boolean inOneRow = true;
            for (var ch : item.toCharArray()) {
                if (hm.get(ch) != k) {
                    inOneRow = false;
                    break;
                }
            }
            if (inOneRow)
                result.add(item);
        }
        return result.toArray(String[]::new);
    }

    void fillMap(HashMap<Character, Integer> hm, String letters, int number) {
        for (var ch : letters.toCharArray()) {
            hm.put(ch, number);
        }
    }
}
