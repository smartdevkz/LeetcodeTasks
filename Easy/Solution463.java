package Easy;

//463. Island Perimeter
public class Solution463 {

    public static void main(String[] args) {
        int[][] grid = new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        var app = new Solution463();
        var res = app.islandPerimeter(grid);
        System.out.println(res);
    }

    public int islandPerimeter(int[][] grid) {
        // find a first land
        int i = 0, j = 0;
        outerloop: for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    break outerloop;
                }
            }
        }
        // start count a perimeter
        return dfs(i, j, grid);
    }

    int dfs(int i, int j, int[][] grid) {
        if (isWater(i, j, grid))
            return 0;
        int s = 0;
        //bottom
        if (isWater(i - 1, j, grid)) {
            s++;
        }
        //top
        if (isWater(i + 1, j, grid)) {
            s++;
        }
        //left
        if (isWater(i, j - 1, grid)) {
            s++;
        }
        //right
        if (isWater(i, j + 1, grid)) {
            s++;
        }
        return s + dfs(i - 1, j, grid) + dfs(i + 1, j, grid) + dfs(i, j - 1, grid) + dfs(i, j + 1, grid);
    }

    boolean isWater(int i, int j, int[][] grid) {
        System.out.println(i + "," + j);
        if (i < 0 || i >= grid.length)
            return true;
        if (j < 0 || j >= grid[i].length)
            return true;
        return grid[i][j] == 0;
    }
}
