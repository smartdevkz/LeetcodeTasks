package Easy;

//https://leetcode.com/problems/maximum-ascending-subarray-sum/
public class Solution1800 {

    public int maxAscendingSum(int[] nums) {
        int max = -1;
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                if (max < sum)
                    max = sum;
                sum = nums[i];
            }
        }
        if (max < sum)
            max = sum;
        return max;
    }
}
