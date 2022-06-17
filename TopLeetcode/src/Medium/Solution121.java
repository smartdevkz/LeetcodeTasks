package Medium;

public class Solution121 {
    public static void main(String[] args) {

    }

    public int MaxProfit(int[] prices) {
        int maxDiff = 0;
        int lower = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > lower) {
                maxDiff = Math.max(maxDiff, prices[i] - lower);
            } else {
                lower = prices[i];
            }
        }
        return maxDiff;
    }
}
