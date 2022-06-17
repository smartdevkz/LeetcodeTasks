package Medium;

//https://leetcode.com/problems/minimum-falling-path-sum/
public class Solution931 {

    int[][] matrix;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        this.matrix = matrix;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = matrix[i][j] + Math.min(getValue(i + 1, j - 1),
                        Math.min(getValue(i + 1, j), getValue(i + 1, j + 1)));
            }
        }
        int best = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            best = Math.min(best, matrix[0][i]);
        }
        return best;
    }

    int getValue(int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix.length) {
            return Integer.MAX_VALUE;
        }
        return matrix[i][j];
    }
}
