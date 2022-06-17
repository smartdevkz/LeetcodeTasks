package Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int n : nums) {
            hs.add(n);
        }

        List<Integer> lst = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!hs.contains(i)) {
                lst.add(i);
            }
        }
        return lst;
    }
}
