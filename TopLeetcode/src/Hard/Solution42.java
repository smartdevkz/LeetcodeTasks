package Hard;

public class Solution42 {
    public int trap(int[] height) {
        int h = 0, d = 0, sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] < h) {
                d += h - height[i];
            } else {
                h = height[i];
                sum += d;
                d = 0;
            }
        }
        d = 0;
        h = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] < h) {
                d += h - height[i];
            } else {
                h = height[i];
                sum += d;
                d = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        var app = new Solution42();
        var res = app.trap(new int[]{2, 0, 2});
        System.out.println(res);
    }
}
