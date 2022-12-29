package Medium;

//https://leetcode.com/problems/word-search/
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean result = backtracking(board, i, j, word, 0);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtracking(char[][] board, int r, int c, String word, int idx) {
        if (idx == word.length()) return true;
        int n = board.length;
        int m = board[0].length;
        if (r >= n || r < 0) return false;
        if (c >= m || c < 0) return false;
        if (board[r][c] == word.charAt(idx)) {
            idx++;
            Character temp = board[r][c];
            board[r][c] = '1';
            boolean res = backtracking(board, r - 1, c, word, idx)
                    || backtracking(board, r + 1, c, word, idx)
                    || backtracking(board, r, c - 1, word, idx)
                    || backtracking(board, r, c + 1, word, idx);
            board[r][c] = temp;
            return res;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        var board = new char[2][2];
        board[0] = new char[]{'a', 'b'};
        board[1] = new char[]{'c', 'd'};
        var app = new Solution79();
        var res = app.exist(board, "abcd");
        System.out.println(res);
    }
}

