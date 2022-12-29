package Hard;

import java.util.Stack;

//https://leetcode.com/problems/maximal-rectangle/
public class Solution85 {

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] count = new int[m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count[j] = matrix[i][j] == '1' ? count[j] + 1 : 0;
            }
            max = Math.max(max, getMaxArea(count, m));
        }
        return max;
    }

    int getMaxArea(int hist[], int n) {
        Stack<Integer> s = new Stack<>();

        int max = 0;
        int i = 0;
        while (i < n) {
            if (s.empty() || hist[i] >= hist[s.peek()]) {
                s.push(i++);
            } else {
                int tp = s.pop();
                int area = hist[tp] * (s.empty() ? i : i - s.peek() - 1);
                max = Math.max(max, area);
            }
        }

        while (!s.empty()) {
            int tp = s.pop();
            int area = hist[tp] * (s.empty() ? i : i - s.peek() - 1);
            max = Math.max(max, area);
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        var app = new Solution85();
        System.out.println(app.maximalRectangle(matrix));
    }
}
