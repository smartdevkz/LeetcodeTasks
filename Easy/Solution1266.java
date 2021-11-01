package Easy;

//1266. Minimum Time Visiting All Points
public class Solution1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int s = 0;
        for (int i = 1; i < points.length; i++) {
            s += getDistance(points[i - 1], points[i]);
        }
        return s;
    }

    int getDistance(int[] a, int[] b) {
        int dX = Math.abs(a[0] - b[0]);
        int dY = Math.abs(a[1] - b[1]);
        if (dX == 0)
            return dY;
        if (dY == 0)
            return dX;
        return Math.max(dX, dY);
    }
}
