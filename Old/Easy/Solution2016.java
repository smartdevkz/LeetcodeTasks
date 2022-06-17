package Easy;

//https://leetcode.com/problems/maximum-difference-between-increasing-elements/
public class Solution2016 {
    public int maximumDifference(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int d = nums[j] - nums[i];
                    if (max < d)
                        max = d;
                }
            }
        }
        return max;
    }
}
