package Easy;

//1725. Number Of Rectangles That Can Form The Largest Square
public class Solution1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int maxCount = 1;
        int max = getMax(rectangles[0]);
        for (int i = 1; i < rectangles.length; i++) {
            var c = getMax(rectangles[i]);
            if (max < c) {
                max = c;
                maxCount = 1;
            } else if (max == c) {
                maxCount++;
            }
        }
        return maxCount;
    }

    int getMax(int[] lw) {
        return Math.min(lw[0], lw[1]);
    }
}
