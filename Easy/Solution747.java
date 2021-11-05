package Easy;

import java.util.Arrays;

//https://leetcode.com/problems/largest-number-at-least-twice-of-others/
public class Solution747 {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1)
            return 0;
        int max = nums[0];
        int maxIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (maxIndex == i)
                continue;
            if (max < nums[i] * 2)
                return -1;
        }

        return maxIndex;
    }
}
