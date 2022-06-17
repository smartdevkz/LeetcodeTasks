package Medium;

//https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
public class Solution1578 {
    public int minCost(String colors, int[] neededTime) {
        int count = 0;

        int prev = 0;
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(prev) == colors.charAt(i)) {
                if (neededTime[prev] <= neededTime[i]) {
                    count += neededTime[prev];
                    prev = i;
                } else {
                    count += neededTime[i];
                }
            } else {
                prev = i;
            }
        }
        return count;
    }
}
