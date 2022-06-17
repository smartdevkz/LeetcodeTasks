package Easy;

import java.util.HashMap;

//1460. Make Two Arrays Equal by Reversing Sub-arrays
public class Solution1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            hm.put(target[i], hm.getOrDefault(target[i], 0) + 1);
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) - 1);
        }

        for (var number : hm.keySet()) {
            if (hm.get(number) != 0)
                return false;
        }
        return true;
    }
}
