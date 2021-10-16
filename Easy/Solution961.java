package Easy;

import java.util.HashSet;

//961. N-Repeated Element in Size 2N Array
public class Solution961 {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hs.contains(nums[i])) {
                return nums[i];
            } else {
                hs.add(nums[i]);
            }
        }
        throw null;
    }

    /**
     * First approach public int repeatedNTimes(int[] nums) { int n = nums.length /
     * 2; HashMap<Integer, Integer> ht = new HashMap<>(); for (int i = 0; i <
     * nums.length; i++) { int count = ht.containsKey(nums[i]) ? ht.get(nums[i]) :
     * 0; ht.put(nums[i], count + 1); }
     * 
     * for (var number : ht.keySet()) { if (ht.get(number) == n) return number; }
     * return 0; }
     */
}
