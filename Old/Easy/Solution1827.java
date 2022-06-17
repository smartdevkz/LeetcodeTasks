package Easy;

import utils.Utils;

//1827. Minimum Operations to Make the Array Increasing
public class Solution1827 {
    public static void main(String[] args) {
        var app = new Solution1827();
        var res = app.minOperations(new int[] { 1, 1, 1 });
        Utils.print(res);
    }

    public int minOperations(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int d = nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i] + d;
                k += d;
            }
        }
        return k;
    }
}
