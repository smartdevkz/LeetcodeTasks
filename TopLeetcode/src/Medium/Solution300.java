package Medium;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        var dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        var maxLen = 1;
        for (int l : dp) {
            maxLen = Math.max(maxLen, l);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        var nums = new int[]{0, 1, 0, 3, 2, 3};
        var app = new Solution300();
        System.out.println(app.lengthOfLIS(nums));
    }
}
