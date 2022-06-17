package Easy;

//https://leetcode.com/problems/convert-1d-array-into-2d-array/
public class Solution2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] res = new int[m][n];
        if (m * n != original.length)
            return new int[0][0];
        int r = 0;
        int c = 0;
        for (int i = 0; i < original.length; i++) {
            res[r][c] = original[i];
            c++;
            if (c >= n) {
                r++;
                c = 0;
            }
        }
        return res;
    }
}
