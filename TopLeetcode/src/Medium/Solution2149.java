package Medium;

//https://leetcode.com/problems/rearrange-array-elements-by-sign/
public class Solution2149 {
    public int[] rearrangeArray(int[] nums) {
        var result = new int[nums.length];

        int i = 0, j = 1;

        for (int a : nums) {
            if (a < 0) {
                result[j] = a;
                j = j + 2;
            } else {
                result[i] = a;
                i = i + 2;
            }
        }
        return result;
    }
}
