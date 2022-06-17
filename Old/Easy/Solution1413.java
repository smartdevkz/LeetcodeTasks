package Easy;

//https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
public class Solution1413 {
    public int minStartValue(int[] nums) {
        int sum = 0;
        boolean started = false;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!started) {
                if (nums[i] < 0) {
                    started = true;
                    sum -= nums[i];
                }
            } else {
                sum -= nums[i];
                if (sum < 0)
                    sum = 0;
            }
        }
        return sum + 1;
    }
}
