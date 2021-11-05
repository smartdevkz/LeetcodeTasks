package Easy;

//https://leetcode.com/problems/find-the-middle-index-in-array/
public class Solution1991 {
    public int findMiddleIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        int i = 0;
        while (leftSum != rightSum && i < nums.length) {
            i++;
            rightSum -= nums[i];
            leftSum += nums[i - 1];
        }
        return leftSum == rightSum ? i : -1;
    }
}
