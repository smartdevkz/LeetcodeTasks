package Easy;

import java.util.HashMap;

//1189. Maximum Number of Balloons
public class Solution1189 {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> hs = new HashMap<>();
        for (var ch : text.toCharArray()) {
            if (ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n') {
                hs.put(ch, hs.getOrDefault(ch, 0) + 1);
            }
        }
        if (hs.size() < 5) {
            return 0;
        }
        hs.put('l', hs.getOrDefault('l', 0) / 2);
        hs.put('o', hs.getOrDefault('o', 0) / 2);

        int min = hs.get('b');
        for (var v : hs.values()) {
            if (min > v)
                min = v;
        }

        return min;
    }
}
