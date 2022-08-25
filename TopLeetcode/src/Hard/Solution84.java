package Hard;

import java.util.Stack;

//https://leetcode.com/problems/largest-rectangle-in-histogram/
public class Solution84 {

    public int largestRectangleArea(int[] heights) {
        return getMaxArea(heights, heights.length);
    }

    int getMaxArea(int hist[], int n)   {
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
            int area = hist[tp] * (s.empty() ? 1 : tp - s.peek());
            max = Math.max(max, area);
        }

        return max;
    }

    public static void main(String[] args) {
        var app = new Solution84();
        var res = app.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(res);
    }


}
