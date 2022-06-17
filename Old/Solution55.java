public class Solution55 {
    public static void main(String[] args) {
        Solution55 app = new Solution55();
        int[] nums = new int[] { 1,0 };
        System.out.println(app.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int n = 0;
        for (int i = 0; i <= n; i++) {
            if (i + nums[i] > n) {
                n = nums[i] + i;
            }
            if (n >= nums.length-1)
                return true;
        }
        return false;
    }
}