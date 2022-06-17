package Easy;

//1909. Remove One Element to Make the Array Strictly Increasing
public class Solution1909 {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 10, 5, 7 };
        var app = new Solution1909();
        app.canBeIncreasing(nums);

    }

    public boolean canBeIncreasing(int[] nums) {
        int left = 0;
        int right = 1;
        int k = 0;
        while (right < nums.length) {
            if (nums[left] <= nums[right]) {
                left = right;
            } else {
                k++;
                if (left == 0 || nums[left - 1] <= nums[right]) {
                    left = right;
                }
            }
            right++;
            if (k > 1)
                return false;
        }
        return true;
    }
}
