package Hard;

import java.util.*;

//https://leetcode.com/problems/sudoku-solver/
public class Solution37 {

    int N = 9;

    char[][] board;
    int[][] rows;
    int[][] cols;
    int[][] boxes;
    boolean sudokuSolved = false;

    public void solveSudoku(char[][] board) {
        initArrays(board);
        backtrack(0, 0);
    }

    void initArrays(char[][] board) {
        this.board = board;
        rows = new int[N][N + 1];
        cols = new int[N][N + 1];
        boxes = new int[N][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.') {
                    int d = Character.getNumericValue(board[i][j]);
                    rows[i][d]++;
                    cols[j][d]++;
                    var boxIdx = getBoxNum(i, j);
                    boxes[boxIdx][d]++;
                }
            }
        }
    }

    int getBoxNum(int row, int col) {
        return 3 * (row / 3) + col / 3;
    }

    void backtrack(int row, int col) {
        if (board[row][col] == '.') {
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    if (!sudokuSolved) {
                        removeNumber(d, row, col);
                    }
                }
            }
        } else {
            placeNextNumbers(row, col);
        }
    }

    boolean couldPlace(int d, int row, int col) {
        int idx = getBoxNum(row, col);
        return rows[row][d] + cols[col][d] + boxes[idx][d] == 0;
    }

    void placeNumber(int d, int row, int col) {
        rows[row][d]++;
        cols[col][d]++;
        int idx = getBoxNum(row, col);
        boxes[idx][d]++;
        board[row][col] = (char) (d + '0');
    }

    void removeNumber(int d, int row, int col) {
        rows[row][d]--;
        cols[col][d]--;
        int idx = getBoxNum(row, col);
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    void placeNextNumbers(int row, int col) {
        if (row == N - 1 && col == N - 1) {
            sudokuSolved = true;
            return;
        }
        if (col == N - 1) backtrack(row + 1, 0);
        else backtrack(row, col + 1);
    }

}
