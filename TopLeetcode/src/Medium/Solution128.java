package Medium;

import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class Solution128 {

    public int longestConsecutive(int[] nums) {
        var hs = new HashSet<Integer>();
        for (int n : nums) {
            hs.add(n);
        }

        int max = 0;

        for (int n : hs) {
            if (!hs.contains(n - 1)) {

                var currentNumber = n;
                var currentStreak = 1;

                while (hs.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentStreak++;
                }

                max = Math.max(max, currentStreak);
            }
        }

        return max;
    }
}
