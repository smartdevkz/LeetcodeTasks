package Easy;

import java.util.HashSet;

//https://leetcode.com/problems/special-positions-in-a-binary-matrix/
public class Solution1582 {
    public int numSpecial(int[][] mat) {
        HashSet<Integer> hsColumns = new HashSet<>();
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            int k = -1;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    if (k == -1) {
                        k = j;
                    } else {
                        k = -1;
                        break;
                    }
                }
            }
            if (k >= 0 && isSpecial(i, k, mat, hsColumns)) {
                count++;
            }
        }
        return count;
    }

    boolean isSpecial(int i, int j, int[][] mat, HashSet<Integer> hsColumns) {
        if (hsColumns.contains(j))
            return false;
        for (int l = 0; l < mat.length; l++) {
            if (mat[l][j] == 1 && l != i) {
                hsColumns.add(j);
                return false;
            }
        }
        return true;
    }
}
