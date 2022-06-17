package Easy;

import java.util.Arrays;

//https://leetcode.com/problems/third-maximum-number/
public class Solution414 {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[nums.length - 1];
        int k = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != prev) {
                k++;
                prev = nums[i];
            }
            if (k == 3) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
