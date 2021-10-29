package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//1370. Increasing Decreasing String
public class Solution1370 {
    public static void main(String[] args) {

    }

    public String sortString(String s) {
        var hm = new HashMap<Character, Integer>();
        List<Character> lst = new ArrayList<>();
        for (var ch : s.toCharArray()) {
            if (!hm.containsKey(ch)) {
                lst.contains(ch);
            }
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        Collections.sort(lst);

        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            // min
            var min = lst.get(0);
            
            // min2
            // repeat
            // max
            // max
            // repeat
        }
        return sb.toString();
    }
}
