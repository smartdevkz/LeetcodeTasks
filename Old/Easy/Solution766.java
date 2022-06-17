package Easy;

//766. Toeplitz Matrix
public class Solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            var a = matrix[0][i];
            for (int j = 0; j < matrix[j].length - i; j++) {
                if (matrix[j][i + j] != a) {
                    return false;
                }
            }
        }
        return true;
    }
}
