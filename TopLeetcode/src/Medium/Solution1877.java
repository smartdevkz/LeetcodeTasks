package Medium;

import java.util.Arrays;

//https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
public class Solution1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[0] + nums[n - 1];
        int left = 1, right = n - 2;
        while (left < right) {
            if (max < nums[left] + nums[right]) {
                max = nums[left] + nums[right];
            }
            left++;
            right--;
        }
        return max;
    }
}
