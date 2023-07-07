package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/
public class Solution1508 {


    public int rangeSum(int[] nums, int n, int left, int right) {
        int k = n * (n + 1) / 2;
        var arr = new int[k];

        int idx = 0;

        for (int i = 0; i < n; i++) {

            int val = 0;
            for (int j = i; j < n; j++) {
                val += nums[j];
                arr[idx++] = val;
            }
        }

        Arrays.sort(arr);

        int result = 0;
        int mod = (int) (1e9 + 7);
        for (int i = left - 1; i <= right - 1; i++) {
            result = result % mod + arr[i];
        }

        return result;
    }


    public static void main(String[] args) {
        var app = new Solution1508();
        var res = app.rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5);
        System.out.println(res);
    }

}
