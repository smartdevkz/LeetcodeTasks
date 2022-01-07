package Medium;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2)
            return 0;

        int n = prices.length;
        int[] hold = new int[n];
        int[] sold = new int[n];

        hold[0] = -prices[0];
        sold[0] = 0;

        for (int i = 1; i <= n; i++) {
            hold[i] = Math.max(hold[i - 1], sold[i - 1] - prices[i]);
            sold[i] = Math.max(sold[i - 1], hold[i - 1] + prices[i] - fee);
        }

        return sold[n];

    }
}
