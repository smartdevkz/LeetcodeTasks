package Medium;

public class Solution45 {

    public int jump(int[] nums) {
        return solve(0, nums);
    }

    int solve(int start, int[] nums) {
        if (start >= nums.length - 1) return 0;

        int n = nums[start] + start;
        if (n >= nums.length - 1) return 1;

        int max = nums[start];
        int maxIndex = start;
        for (int i = start; i <= n; i++) {
            if (max <= nums[i] + i) {
                max = nums[i] + i;
                maxIndex = i;
            }
        }
        return 1 + solve(maxIndex, nums);
    }

    public static void main(String[] args) {
        var app = new Solution45();
        var res = app.jump(new int[]{1, 1});
        System.out.println(res);
    }
}
