package Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/two-out-of-three/
public class Solution2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> res = new ArrayList<>();

        var hs = getHs(nums1);
        for (int item : nums2) {
            if (hs.contains(item)) {
                res.add(item);
                hs.remove(item);
            }

        }
        for (int item : nums3) {
            if (hs.contains(item)) {
                res.add(item);
                hs.remove(item);
            }
        }

        hs = getHs(nums2);
        for (int item : res) {
            if (hs.contains(item))
                hs.remove(item);
        }
        for (int item : nums3) {
            if (hs.contains(item)) {
                res.add(item);
                hs.remove(item);
            }
        }

        return res;
    }

    HashSet<Integer> getHs(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int item : nums) {
            hs.add(item);
        }
        return hs;
    }
}
