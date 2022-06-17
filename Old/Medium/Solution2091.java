package Medium;

//https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
public class Solution2091 {
    public static void main(String[] args) {
        var app = new Solution2091();
        System.out.println(app.minimumDeletions(
                new int[] { 72956, -44432, 78333, 31358, -96449, -24776 }));
    }

    public int minimumDeletions(int[] nums) {
        int maxIndex = 0;
        int minIndex = 0;
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
            if (min > nums[i]) {
                min = nums[i];
                minIndex = i;
            }
        }

        if (minIndex > maxIndex) {
            var t = minIndex;
            minIndex = maxIndex;
            maxIndex = t;
        }

        return Math.min(maxIndex + 1, Math.min(nums.length - minIndex, minIndex + 1 + nums.length - maxIndex));
    }
}
