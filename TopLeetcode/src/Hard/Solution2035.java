package Hard;

import java.util.Arrays;

//https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
public class Solution2035 {
    public int minimumDifference(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int sp = 0;
        int s = Arrays.stream(nums).sum();
        int minDiff = Integer.MAX_VALUE;
        while (i < j) {
            int diff1 = getDiff(nums[i], sp, s);
            int diff2 = getDiff(nums[j], sp, s);
            if (diff1 < diff2) {
                if (minDiff > diff1) {
                    minDiff = diff1;
                    sp += nums[i];
                    i++;
                } else {
                    return minDiff;
                }
            } else {
                if (minDiff > diff2) {
                    minDiff = diff2;
                    sp += nums[j];
                    j--;
                } else {
                    return minDiff;
                }
            }
        }
        return minDiff;
    }

    private int getDiff(int a, int sp, int s) {
        return Math.abs(s - 2 * (sp + a));
    }

    public static void main(String[] args) {
        var app = new Solution2035();
        System.out.println(app.minimumDifference(new int[]{0, 6, 11, 17, 18, 24}));
    }
}
