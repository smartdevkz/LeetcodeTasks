package Medium;

import java.util.Arrays;
import java.util.HashSet;

import utils.Utils;

//https://leetcode.com/problems/sort-integers-by-the-power-value/
public class Solution1387 {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3 };
        
        /*
         * var app = new Solution1387();
         * var arr = app.getPowers(12, 15);
         * Utils.printArray(arr);
         * var res = app.getKth(12, 15, 2);
         * Utils.print(res);
         */
    }

    public int getKth(int lo, int hi, int k) {
        var arr = getPowers(lo, hi);
        HashSet<Integer> hs = new HashSet<>();
        int minIndex = 0;
        for (int i = 0; i < k; i++) {
            minIndex = 0;
            int min = arr[minIndex];
            for (int j = 0; j < arr.length; j++) {
                if (hs.contains(j))
                    continue;
                if (hs.contains(minIndex) || min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                    continue;
                }
            }
            hs.add(minIndex);
            System.out.println("minIndex: " + minIndex + " val: " + min);
        }
        return lo + minIndex;
    }

    private int[] getPowers(int lo, int hi) {
        var res = new int[hi - lo + 1];
        int j = 0;
        for (int i = lo; i <= hi; i++) {
            res[j] = getPower(i);
            j++;
        }
        return res;
    }

    public int getPower(int n) {
        int p = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
            p++;
        }
        return p;
    }

}
