package Medium;

import java.util.Arrays;

public class Solution1033 {
    public int[] numMovesStones(int a, int b, int c) {
        var arr = new int[]{a, b, c};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];
        int min = (b - a > 1 ? 1 : 0) + (c - b > 1 ? 1 : 0);

        if (b - a == 2 || c - b == 2) {
            min = 1;
        }
        int max = c - a - 2;
        return new int[]{min, max};
    }
}
