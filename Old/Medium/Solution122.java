package Medium;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class Solution122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int d = prices[i] - prices[i - 1];
            if (d > 0) {
                sum += d;
            }
        }
        return sum;
    }
}
