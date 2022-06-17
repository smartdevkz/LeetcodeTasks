package Medium;

//https://leetcode.com/problems/arithmetic-slices/
public class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;
        int n = nums.length;
        int count = 0;

        int prevD = nums[1] - nums[0];
        int k = 2;
        for (int i = 2; i < n; i++) {
            int d = nums[i] - nums[i - 1];
            if (prevD == d) {
                k++;
            } else {
                count += getCount(k);
                prevD = d;
                k = 2;
            }
        }

        if (k > 2) {
            count += getCount(k);
        }

        return count;
    }

    int getCount(int k) {
        if (k < 3)
            return 0;
        return ((k - 1) * (k - 2)) / 2;
    }

}
