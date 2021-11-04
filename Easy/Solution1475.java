package Easy;

//1475. Final Prices With a Special Discount in a Shop
public class Solution1475 {
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            prices[i] -= getDiscount(i, prices);
        }
        return prices;
    }

    int getDiscount(int i, int[] prices) {
        for (int j = i + 1; j < prices.length; j++) {
            if (prices[i] >= prices[j])
                return prices[j];
        }
        return 0;
    }

}
