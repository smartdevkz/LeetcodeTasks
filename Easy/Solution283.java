package Easy;

import utils.Utils;

//283. Move Zeroes
public class Solution283 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1 };
        var app = new Solution977();
        app.moveZeroes(nums);
        Utils.printArray(nums);
    }

    public void moveZeroes(int[] nums) {
        int l = 0;
        while (l < nums.length && nums[l] != 0) {
            l++;
        }
        move(l, 1, nums);
    }

    void move(int l, int k, int[] nums) {
        if (l + k > nums.length - 1)
            return;
        int next = nums[l + k];
        if (next == 0) {
            k++;
        } else {
            swipe(nums, l, l + k);
            l++;
        }
        move(l, k, nums);
    }

    void swipe(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
