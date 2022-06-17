package Easy;

import java.lang.reflect.Array;
import java.util.Arrays;

//https://leetcode.com/problems/smallest-range-i/
public class Solution908 {
    public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        int middle = (max + min) / 2;
        int x1 = middle - min;
        if (x1 > Math.abs(k))
            x1 = Math.abs(k);
        int x2 = max - middle;
        if (x2 > Math.abs(k))
            x2 = Math.abs(k);
        return max - x2 - min - x1;
    }
}
