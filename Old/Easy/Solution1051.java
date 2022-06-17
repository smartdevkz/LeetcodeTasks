package Easy;

import java.util.Arrays;

//1051. Height Checker
public class Solution1051 {
    public int heightChecker(int[] heights) {
        var origin = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            origin[i] = heights[i];
        }
        Arrays.sort(heights);
        int k = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != origin[i]) {
                k++;
            }
        }
        return k;
    }
}