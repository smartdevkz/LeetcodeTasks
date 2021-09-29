package Easy.DynamicProgramming;

import java.util.Arrays;

//746. Min Cost Climbing Stairs
//Best explanation: https://leetcode.com/problems/min-cost-climbing-stairs/discuss/476388/4-ways-or-Step-by-step-from-Recursion-greater-top-down-DP-greater-bottom-up-DP-greater-fine-tuning
public class Solution746 {
    public static void main(String[] args) {
        var app = new Solution746();
        int res = app.minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 });
        System.out.println(res);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (n <= 2)
            Math.min(first, second);
        for (int i = 2; i < n; i++) {
            int t = second;
            second = cost[i] + Math.min(first, second);
            first = t;
        }
        return Math.min(first, second);
    }
}
