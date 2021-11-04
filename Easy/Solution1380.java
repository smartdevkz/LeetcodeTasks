package Easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/lucky-numbers-in-a-matrix/
public class Solution1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            int minJ = 0;
            for (int j = 1; j < matrix[i].length; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    minJ = j;
                }
            }
            boolean isLucky = true;
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][minJ] > min) {
                    isLucky = false;
                    break;
                }
            }
            if (isLucky)
                res.add(min);
        }
        return res;
    }
}
