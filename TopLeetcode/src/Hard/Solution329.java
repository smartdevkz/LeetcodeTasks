package Hard;

public class Solution329 {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        m = matrix.length;
        n = matrix[0].length;
        var cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j, matrix, cache));
            }
        }
        return res;
    }

    public int dfs(int i, int j, int[][] arr, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && arr[x][y] > arr[i][j])
                cache[i][j] = Math.max(cache[i][j], dfs(x, y, arr, cache));
        }
        return ++cache[i][j];
    }
}
