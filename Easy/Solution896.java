package Easy;

//https://leetcode.com/problems/monotonic-array/
public class Solution896 {
    public boolean isMonotonic(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                continue;
            if (k == 0) {
                k = nums[i] > nums[i - 1] ? 1 : -1;
            } else {
                int current = nums[i] > nums[i - 1] ? 1 : -1;
                if (current != k)
                    return false;
            }
        }
        return true;
    }
}
