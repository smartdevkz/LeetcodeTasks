package Medium;

//https://leetcode.com/problems/ways-to-make-a-fair-array/
public class Solution1664 {

    public static void main(String[] args) {
        var arr = new int[] { 2, 1, 6, 4, 5, 8, 3, 5, 8, 1, 4, 2, 1 };
        var app = new Solution1664();
        app.waysToMakeFair(arr);
    }

    public int waysToMakeFair(int[] nums) {
        int res = 0, n = nums.length, left[] = new int[2], right[] = new int[2];
        for (int i = 0; i < n; i++)
            right[i % 2] += nums[i];
        for (int i = 0; i < n; i++) {
            right[i % 2] -= nums[i];
            if (left[0] + right[1] == left[1] + right[0])
                res++;
            left[i % 2] += nums[i];
        }
        return res;
    }

}
