package Hard;

import java.util.Arrays;

//https://leetcode.com/problems/reverse-pairs/
public class Solution493 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && nums[i] / 2.0 > nums[j]) j++;
            count += j - (mid + 1);
        }
        Arrays.sort(nums, start, end + 1);
        return count;
    }
}
