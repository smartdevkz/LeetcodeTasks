package Easy;

import java.rmi.server.RemoteStub;

//463. Island Perimeter
public class Solution463 {

    public static void main(String[] args) {
        int[][] grid = new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        var app = new Solution463();
        var res = app.islandPerimeter(grid);
        System.out.println(res);
    }

    public int islandPerimeter(int[][] grid) {
        int p = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                p += getPerimeter(i, j, grid);
            }
        }
        return p;
    }

    int getPerimeter(int i, int j, int[][] grid) {
        if (grid[i][j] == 0)
            return 0;
        int p = 0;
        if (isWater(i + 1, j, grid))
            p++;
        if (isWater(i - 1, j, grid))
            p++;
        if (isWater(i, j + 1, grid))
            p++;
        if (isWater(i, j - 1, grid))
            p++;
        return p;
    }

    boolean isWater(int i, int j, int[][] grid) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length) {
            return grid[i][j] == 0;
        }
        return true;
    }
}
