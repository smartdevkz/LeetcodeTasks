package Easy;

//https://leetcode.com/problems/matrix-cells-in-distance-order/
public class Solution1030 {
    int k = -1;

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[1][cols * rows];
        int[][] grid = new int[1][cols * rows];
        dfs(rCenter, cCenter, grid, res);
        return res;
    }

    void dfs(int i, int j, int[][] grid, int[][] res) {
        addPoint(i, j, grid, res);
        addPoint(i - 1, j, grid, res);
        addPoint(i + 1, j, grid, res);
        addPoint(i, j - 1, grid, res);
        addPoint(i, j + 1, grid, res);
        if (hasNeighbours(i - 1, j, grid)) {
            dfs(i - 1, j, grid, res);
        }
        if (hasNeighbours(i + 1, j, grid)) {
            dfs(i + 1, j, grid, res);
        }
        if (hasNeighbours(i, j - 1, grid)) {
            dfs(i, j - 1, grid, res);
        }
        if (hasNeighbours(i, j + 1, grid)) {
            dfs(i, j + 1, grid, res);
        }
    }

    int getPoint(int i, int j, int[][] grid) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length) {
            return grid[i][j];
        }
        return 1;
    }

    void addPoint(int i, int j, int[][] grid, int[][] res) {
        if (getPoint(i, j, grid) == 0) {
            grid[i][j] = 1;
            res[0][++k] = grid[i][j];
        }
    }

    boolean hasNeighbours(int i, int j, int[][] grid) {
        return getPoint(i - 1, j, grid) == 0 && getPoint(i + 1, j, grid) == 0 && getPoint(i, j - 1, grid) == 0
                && getPoint(i, j + 1, grid) == 0;
    }
}
