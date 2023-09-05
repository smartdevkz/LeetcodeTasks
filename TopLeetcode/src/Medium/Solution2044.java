package Medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
public class Solution2044 {

    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int a : nums) {
            max |= a;
        }

        int count = 0;
        var subsets = generateSubsets(nums);

        for (var s : subsets) {
            var k = 0;
            for (int a : s) {
                k |= a;
            }
            if (k == max) count++;
        }

        return count;
    }

    private List<List<Integer>> generateSubsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<>(), 0, nums, result);
        return result;
    }

    private void backtrack(List<Integer> lst, int idx, int[] nums, List<List<Integer>> result) {
        if (idx == nums.length) return;
        lst.add(nums[idx]);
        result.add(new ArrayList<>(lst));
        backtrack(lst, idx + 1, nums, result);
        lst.remove(lst.size() - 1);
        backtrack(lst, idx + 1, nums, result);
    }

    public static void main(String[] args) {
        //var app = new Solution2044();
        //app.generateSubsets(new int[]{3, 1, 2, 5});
        System.out.println(2 | 5);
    }

}
