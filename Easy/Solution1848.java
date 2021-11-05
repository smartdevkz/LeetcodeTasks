package Easy;

//https://leetcode.com/problems/minimum-distance-to-the-target-element/
public class Solution1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        int min = nums.length + 15;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (min > Math.abs(i - start)) {
                    min = Math.abs(i - start);
                }
            }
        }
        return min;
    }
}
