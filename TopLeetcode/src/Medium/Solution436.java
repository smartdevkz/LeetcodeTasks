package Medium;

//https://leetcode.com/problems/find-right-interval/
public class Solution436 {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start == end) {
                result[i] = i;
                continue;
            }
            int need = -1;
            for (int j = 0; j < intervals.length; j++) {
                if (i == j) continue;

                if (intervals[j][0] >= end && (need == -1 || intervals[need][0] > intervals[j][0])) {
                    need = j;
                }
            }
            result[i] = need;
        }
        return result;
    }
}
