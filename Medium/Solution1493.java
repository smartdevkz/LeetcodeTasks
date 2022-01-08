package Medium;

//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
public class Solution1493 {
    public int longestSubarray(int[] nums) {
        int prev = 0;
        int current = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                current++;
            } else {
                max = Math.max(max, current + prev);
                prev = current;
                current = 0;
            }
        }

        if (current == nums.length) {
            return current - 1;
        }

        if (current > 0) {
            max = Math.max(max, current + prev);
        }

        return max;
    }
}
