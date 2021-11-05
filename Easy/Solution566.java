package Easy;

//https://leetcode.com/problems/reshape-the-matrix/
public class Solution566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length)
            return mat;
        int[][] res = new int[r][c];
        int m = 0;
        int n = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                res[m][n] = mat[i][j];
                n++;
                if (n >= c) {
                    m++;
                    n = 0;
                }
            }
        }
        return res;
    }
}
