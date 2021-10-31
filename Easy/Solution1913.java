package Easy;

import java.util.Arrays;

//1913. Maximum Product Difference Between Two Pairs
public class Solution1913 {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - 1] * nums[n - 2] - nums[0] * nums[1];
    }
}
