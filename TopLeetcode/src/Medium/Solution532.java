package Medium;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/k-diff-pairs-in-an-array/
public class Solution532 {
    HashSet<Integer> res = new HashSet<>();

    public int findPairs(int[] nums, int k) {
        var hm = new HashMap<Integer, Integer>();
        for (var item : nums) {
            var count = hm.getOrDefault(item, 0);
            hm.put(item, ++count);
        }

        for (var item : nums) {
            check(item, item - k, hm);
            check(item, item + k, hm);
        }
        return res.size();
    }

    void check(int item, int need, HashMap<Integer, Integer> hm) {
        if (hm.containsKey(need)) {
            if (item < need) {
                res.add(item);
            } else if (need < item) {
                res.add(need);
            } else {
                int count = hm.get(need);
                if (count > 1) {
                    res.add(need);
                }
            }
        }
    }
}
