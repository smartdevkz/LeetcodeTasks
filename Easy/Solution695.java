package Easy;

//695. Max Area of Island
public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                int sum = getSum(grid, i, j);
                if (sum > max)
                    max = sum;
            }
        }

        return max;
    }

    int getSum(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + getSum(grid, i - 1, j) + getSum(grid, i + 1, j) + getSum(grid, i, j - 1)
                    + getSum(grid, i, j + 1);
        }
        return 0;
    }
}
