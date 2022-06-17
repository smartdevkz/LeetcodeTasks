package Easy;

//https://leetcode.com/problems/projection-area-of-3d-shapes/
public class Solution883 {
    public int projectionArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            int maxX = 0;
            int maxY = 0;
            for (int j = 0; j < grid.length; j++) {
                if (maxX < grid[i][j])
                    maxX = grid[i][j];
                if (maxY < grid[j][i]) {
                    maxY = grid[j][i];
                }
                if (grid[i][j] > 0)
                    sum++;
            }
            sum += maxX;
            sum += maxY;
        }
        return sum;
    }
}
