package Medium;

//https://leetcode.com/problems/surrounded-regions/
public class Solution130 {
    int n, m;

    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(i, 0, board);
            dfs(i, m - 1, board);
        }

        for (int i = 0; i < m; i++) {
            dfs(0, i, board);
            dfs(n-1, i, board);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    void dfs(int row, int col, char[][] board) {
        if (row < 0 || row >= n || col < 0 || col >= m) return;
        if (board[row][col] != 'O') return;
        board[row][col] = 'T';
        dfs(row, col - 1, board);
        dfs(row, col + 1, board);
        dfs(row - 1, col, board);
        dfs(row + 1, col, board);
    }
}
