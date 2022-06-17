package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
public class Solution1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int totalSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            totalSum += nums[i];
        }

        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            res.add(nums[i]);
            if (sum > totalSum - sum) {
                return res;
            }
            
        }
        return null;
    }
}
