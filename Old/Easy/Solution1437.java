package Easy;

//https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
public class Solution1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int s = 0;
        boolean hasStarted = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (!hasStarted) {
                    hasStarted = true;
                } else {
                    if (s < k) {
                        return false;
                    }
                    s = 0;
                }
            } else {
                if (hasStarted)
                    s++;
            }
        }
        return true;
    }
}
