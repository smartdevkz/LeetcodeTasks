package Easy;

import java.util.HashMap;

import utils.Utils;

//https://leetcode.com/problems/sort-array-by-increasing-frequency/
public class Solution1636 {

    public static void main(String[] args) {
        var app = new Solution1636();
        var arr = app.frequencySort(new int[]{1,1,2,2,2,3});
    }

    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        
        boolean sorted = false;
        while (sorted) {
            sorted = true;
            for (int i = 1; i < nums.length; i++) {
                if (hm.get(nums[i - 1]) > hm.get(nums[i])
                        || (hm.get(nums[i - 1]) == hm.get(nums[i]) && nums[i - 1] < nums[i])) {
                    var t = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = t;
                    sorted = false;
                }
            }
        }

        return nums;
    }

}
