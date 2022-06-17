package Easy;

//https://leetcode.com/problems/max-consecutive-ones/
public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        boolean hasStarted = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (!hasStarted) {
                    hasStarted = true;
                }
                count++;
            } else {
                if (hasStarted) {
                    hasStarted = false;
                    if (max < count)
                        max = count;
                    count = 0;
                }
            }
        }
        if (max < count)
            max = count;
        return max;
    }
}
