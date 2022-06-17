package Medium;

import utils.Utils;

//https://leetcode.com/problems/count-square-submatrices-with-all-ones/
public class Solution1277 {
    public static void main(String[] args) {
        var arr = new int[][] {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 }
        };
        var app = new Solution1277();
        var res = app.countSquares(arr);
        Utils.print(res);
    }

    int[][] matrix;

    public int countSquares(int[][] matrix) {
        this.matrix = matrix;
        int maxSide = Math.min(matrix.length, matrix[0].length);
        int count = 0;
        for (int i = 1; i <= maxSide; i++) {
            count += getCount(i);
        }
        return count;
    }

    int getCount(int side) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (isSquare(i, j, side)) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean isSquare(int r, int c, int side) {
        int count = 0;
        for (int i = r; i < matrix.length && i < r + side; i++) {
            for (int j = c; j < matrix[i].length && j < c + side; j++) {
                if (matrix[i][j] == 0)
                    return false;
                count++;
            }
        }
        return count == side * side;
    }
}
