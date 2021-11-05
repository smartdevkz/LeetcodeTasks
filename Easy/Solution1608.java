package Easy;

//https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
public class Solution1608 {
    public int specialArray(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            boolean isSpecial = true;
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    count++;
                    if (count > i) {
                        isSpecial = false;
                        break;
                    }
                }
            }
            if (isSpecial && count == i)
                return i;
        }
        return -1;
    }
}
