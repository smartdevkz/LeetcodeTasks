package Medium;

import java.util.HashMap;

//https://leetcode.com/problems/minimum-cost-for-tickets/
public class Solution983 {
    public static void main(String[] args) {
        var app = new Solution983();
        var days = new int[] { 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 24, 25, 27, 28, 29,
                30, 31, 34, 37, 38, 39, 41, 43, 44, 45, 47, 48, 49, 54, 57, 60, 62, 63, 66, 69, 70, 72, 74, 76, 78, 80,
                81, 82, 83, 84, 85, 88, 89, 91, 93, 94, 97, 99 };
        var costs = new int[] { 9, 38, 134 };
        var res = app.mincostTickets(days, costs);
        System.out.println(res);
    }

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        return solve(0);
    }

    int[] days;
    int[] costs;
    HashMap<Integer, HashMap<Integer, Integer>> memo = new HashMap<>();

    private int solve(int dayIndex) {
        if (dayIndex >= days.length)
            return 0;
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; i++) {
            var nextDayIndex = getNextDayIndex(dayIndex, getDayCount(i));
            var sum = getMemoVal(nextDayIndex, costs[i]);
            if (sum == null)
                sum = costs[i] + solve(nextDayIndex);
            best = Math.min(best, sum);
            setMemoVal(dayIndex, costs[i], best);
        }
        return best;
    }

    private int getNextDayIndex(int dayIndex, int dayCount) {
        int start = days[dayIndex] + dayCount;
        int i;
        for (i = dayIndex; i < days.length; i++) {
            if (days[i] >= start) {
                return i;
            }
        }
        return i;
    }

    private int getDayCount(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 7;
            case 2:
                return 30;
            default:
                return 0;
        }
    }

    private Integer getMemoVal(int dayIndex, int cost) {
        var hm = memo.getOrDefault(dayIndex, null);
        if (hm == null)
            return null;
        return hm.getOrDefault(cost, null);
    }

    private void setMemoVal(int dayIndex, int cost, int val) {
        var hm = memo.getOrDefault(dayIndex, new HashMap<>());
        hm.put(cost, val);
        memo.put(dayIndex, hm);
    }
}
