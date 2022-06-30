package Hard;

public class Solution42 {
    public int trap(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;
        while (left < right) {
            if (heights[left] < heights[right]) {
                if (leftMax <= heights[left]) {
                    leftMax = heights[left];
                } else {
                    result += leftMax - heights[left];
                }
                left++;
            } else {
                if (rightMax <= heights[right]) {
                    rightMax = heights[right];
                } else {
                    result += rightMax - heights[right];
                }
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var app = new Solution42();
        var res = app.trap(new int[]{2, 0, 2});
        System.out.println(res);
    }
}
