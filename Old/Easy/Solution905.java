package Easy;

import utils.Utils;

//https://leetcode.com/problems/sort-array-by-parity/
public class Solution905 {

    public static void main(String[] args) {
        var app = new Solution905();
        Utils.printArray(app.sortArrayByParity(new int[] { 3, 1, 2, 4 }));
    }

    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 1 && nums[right] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 == 0)
                left++;
            if (nums[right] % 2 == 1)
                right--;
        }
        return nums;
    }
}
