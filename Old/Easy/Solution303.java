package Easy;

//https://leetcode.com/problems/range-sum-query-immutable/
public class Solution303 {
    class NumArray {
        int[] items;

        public NumArray(int[] nums) {
            items = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += items[i];
            }
            return sum;
        }
    }
}
