package Easy;

import java.util.HashMap;
import java.util.HashSet;

//1207. Unique Number of Occurrences
public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        HashSet<Integer> hs = new HashSet<>(hm.values());
        return hs.size()==hm.size();
    }
}
