package Hard;

import java.util.Arrays;

//https://leetcode.com/problems/delivering-boxes-from-storage-to-ports/
public class Solution1687 {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] dp = new int[n + 1];
        int weight = 0;
        int cost = 2;
        for (int l = 0, r = 0; r < n; r++) {
            weight += boxes[r][1];
            if (r != 0 && boxes[r][0] != boxes[r - 1][0]) cost++;
            while (r - l >= maxBoxes || weight > maxWeight || (l < r && dp[l] == dp[l + 1])) {
                weight -= boxes[l][1];
                if (boxes[l + 1][0] != boxes[l][0]) cost--;
                l++;
            }
            dp[r + 1] = cost + dp[l];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        var app = new Solution1687();
        var boxes = new int[][]{{1, 1}, {2, 1}, {1, 1}};
        var res = app.boxDelivering(boxes, 2, 3, 3);
        System.out.println(res);
    }
}
