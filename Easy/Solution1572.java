package Easy;

//1572. Matrix Diagonal Sum
public class Solution1572 {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            if (mat.length - 1 - i == i) {
                sum += mat[i][i];
            } else {
                sum += mat[i][i];
                sum += mat[mat.length - 1 - i][i];
            }
        }
        return sum;
    }
}
