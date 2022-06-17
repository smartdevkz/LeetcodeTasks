package Easy;

import utils.Utils;

//https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
public class Solution1356 {
    public static void main(String[] args) {
        var app = new Solution1356();
        Utils.printArray(app.sortByBits(new int[] { 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 }));
    }

    public int[] sortByBits(int[] arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < arr.length; i++) {
                Utils.print(Integer.bitCount(arr[i - 1]) + " vs " + Integer.bitCount(arr[i]));
                if (Integer.bitCount(arr[i - 1]) > Integer.bitCount(arr[i])
                        || (Integer.bitCount(arr[i - 1]) == Integer.bitCount(arr[i]) && arr[i - 1] > arr[i])) {
                    int t = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = t;
                    sorted = false;
                }
            }
        }
        return arr;
    }
}
