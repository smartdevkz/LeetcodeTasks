package Easy;

//1351. Count Negative Numbers in a Sorted Matrix
public class Solution1351 {
    public static void main(String[] args) {
        var app = new Solution1351();
        // int[][] grid = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1,
        // -1, -2, -3 } };
        int[][] grid = { { 5, 1, 0 }, { -1, -1, -1 } };
        var res = app.countNegatives(grid);
        System.out.println(res);
    }

    public int countNegatives(int[][] grid) {
        int s = 0;
        for (var arr : grid) {
            int l = 0;
            int r = arr.length - 1;
            if (arr[r] >= 0)
                break;
            if (arr[l] < 0) {
                s += arr.length;
                break;
            }
            while (r - l > 1) {
                int d = l + (r - l) / 2;
                if (arr[d] < 0) {
                    r = d;
                } else {
                    l = d;
                }
            }
            if (arr[l] < 0)
                r = l;
            s += (arr.length - r);
        }
        return s;
    }
}
