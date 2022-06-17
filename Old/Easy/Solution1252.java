package Easy;

//1252. Cells with Odd Values in a Matrix
public class Solution1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];
        int res = 0;
        for (var rc : indices) {
            res = oddCells(arr, rc);
        }
        return res;
    }

    int oddCells(int[][] arr, int[] rc) {
        int r = rc[0], c = rc[1];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int val = arr[i][j];
                if (i == r)
                    val++;
                if (j == c)
                    val++;
                arr[i][j] = val;
                if (val % 2 == 1)
                    count++;
            }
        }
        return count;
    }
}
