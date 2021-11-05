package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Utils;

//https://leetcode.com/problems/duplicate-zeros/
public class Solution1089 {
    public static void main(String[] args) {
        var app = new Solution1089();
        var arr = new int[] { 1, 0, 2, 3, 0, 4, 5, 0 };
        app.duplicateZeros(arr);
        Utils.printArray(arr);
    }

    public void duplicateZeros(int[] arr) {
        int[] temp = new int[arr.length];
        int k = 0;
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[k];
            if (arr[k] == 0) {
                i++;
                if (i < temp.length) {
                    temp[i] = 0;
                }
            }
            k++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}
