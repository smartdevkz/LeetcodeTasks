package Medium;

//https://leetcode.com/problems/house-robber/
public class Solution198 {
    int[] nums = null;
    Integer[] dp = null;

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        this.nums = nums;
        this.dp = new Integer[nums.length];
        return Math.max(solve(0), solve(1));
    }

    int solve(int idx) {
        if (idx >= nums.length) return 0;
        if (dp[idx] != null) {
            return dp[idx];
        }
        int left = solve(idx + 2);
        int right = solve(idx + 3);
        int sum = Math.max(left, right) + nums[idx];
        dp[idx] = sum;
        return sum;
    }

}
