package Hard;

import java.util.*;

//https://leetcode.com/problems/sudoku-solver/
public class Solution37 {
    int count = 0;

    public void solveSudoku(char[][] board) {
        HashMap<Integer, List<Integer>> rows = new HashMap<>();
        HashMap<Integer, List<Integer>> cols = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            var lst1 = new ArrayList<Integer>();
            var lst2 = new ArrayList<Integer>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = '0';
                    count++;
                }
                int n1 = Character.getNumericValue(board[i][j]);
                lst1.add(n1);
                if (board[j][i] == '.') {
                    board[j][i] = '0';
                    count++;
                }
                int n2 = Character.getNumericValue(board[j][i]);
                lst2.add(n2);
            }
            rows.put(i, lst1);
            cols.put(i, lst2);
        }

        int k = 0;
        while (count > 0) {
            fill(k, rows, cols, board);
            k++;
            if (k == 9) k = 0;
        }
    }

    void fill(int k, HashMap<Integer, List<Integer>> rows, HashMap<Integer, List<Integer>> cols, char[][] board) {
        int rowIdx = 3 * (k / 3);
        int colIdx = 3 * (k % 3);
        var possible = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = rowIdx; i < rowIdx + 3; i++) {
            for (int j = colIdx; j < colIdx + 3; j++) {
                int n = Character.getNumericValue(board[i][j]);
                possible.remove(n);
            }
        }
        for (int i = rowIdx; i < rowIdx + 3; i++) {
            for (int j = colIdx; j < colIdx + 3; j++) {
                if (board[i][j] != '0') continue;
                var options = new HashSet<>(possible);
                var rowValues = rows.get(i);
                for (var n : rowValues) {
                    options.remove(n);
                }
                var colValues = cols.get(j);
                for (var n : colValues) {
                    options.remove(n);
                }
                if (options.size() != 1) continue;
                var value = (int) options.toArray()[0];
                board[i][j] = (char) value;
                rowValues.set(j, value);
                colValues.set(i, value);
                count--;
            }
        }
    }
}
