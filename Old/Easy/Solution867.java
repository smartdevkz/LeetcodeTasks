package Easy;

import utils.Utils;

//https://leetcode.com/problems/transpose-matrix/
public class Solution867 {
    public static void main(String[] args) {
        var matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
        var app = new Solution867();
        Utils.print(app.transpose(matrix));
    }

    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int r = 0, c = 0;
        int[][] res = new int[m][n];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                res[r][c] = matrix[j][i];
                c++;
                if (c >= n) {
                    r++;
                    c = 0;
                }
            }
        }
        return res;
    }
}
