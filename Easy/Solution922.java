package Easy;

import utils.Utils;

//https://leetcode.com/problems/sort-array-by-parity-ii/
public class Solution922 {

    public static void main(String[] args) {
        var app = new Solution922();
        Utils.printArray(app.sortArrayByParityII(new int[] { 4, 2, 5, 7 }));
    }

    public int[] sortArrayByParityII(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length && j < nums.length) {
            if ((i % 2 == 0 && nums[i] % 2 == 0) || i % 2 == 1) {
                i++;
            }
            if ((j % 2 == 1 && nums[j] % 2 == 1) || j % 2 == 0) {
                j++;
            }
            if (i % 2 == 0 && nums[i] % 2 == 1 && j % 2 == 1 && nums[j] % 2 == 0) {
                var t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        return nums;
    }
}
