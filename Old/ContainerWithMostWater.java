public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 4, 5, 18, 17, 6 };
        int res = maxArea2(arr);
        System.out.println(res);
    }

    public static int maxArea(int[] height) {
        if (height.length < 2)
            return 0;

        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int d = j - i;
                int h = height[i] < height[j] ? height[i] : height[j];
                int s = d * h;
                if (max < s)
                    max = s;
            }
        }
        return max;
    }

    public static int maxArea2(int[] height) {
        if (height.length < 2)
            return 0;

        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int h = height[l] < height[r] ? height[l] : height[r];
            int s = h * (r - l);
            if (s > max)
                max = s;
            if (height[l] <= height[r])
                l++;
            else
                r--;
        }

        return max;
    }
}