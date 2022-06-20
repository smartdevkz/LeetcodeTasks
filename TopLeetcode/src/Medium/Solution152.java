package Medium;

public class Solution152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = max;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp = Math.max(curr, Math.max(curr * max, curr * min));
            min = Math.min(curr, Math.min(curr * max, curr * min));
            max = temp;

            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 2, 3, -5, -2};
        var app = new Solution152();
        var res = app.maxProduct(nums);
        System.out.println(res);
    }
}
