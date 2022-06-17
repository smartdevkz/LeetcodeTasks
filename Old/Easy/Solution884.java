package Easy;

import java.util.HashMap;

//884. Uncommon Words from Two Sentences
public class Solution884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (var str : s1.split(" ")) {
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }
        
        for (var str : s2.split(" ")) {
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }

        var iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            var key = iterator.next();
            if (hm.get(key) != 1)
                iterator.remove();
        }

        return hm.keySet().toArray(new String[hm.size()]);
    }
}
