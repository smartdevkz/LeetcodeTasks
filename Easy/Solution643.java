package Easy;

import utils.Utils;

//643. Maximum Average Subarray I
public class Solution643 {

    public static void main(String[] args) {
        var app = new Solution643();
        var res = app.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4);
        Utils.print(res);
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = sum;
        for (int i = 1; i <= nums.length - k; i++) {
            sum = getSum(i, k, sum, nums);
            if (sum > max)
                max = sum;
        }
        return (double) max / k;
    }

    int getSum(int i, int k, int sum, int[] nums) {
        return sum - nums[i - 1] + nums[i + k - 1];
    }
}
