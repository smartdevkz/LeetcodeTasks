package Easy;

import java.util.ArrayList;
import java.util.*;

//https://leetcode.com/problems/minimum-absolute-difference/
public class Solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        int minDiff = Math.abs(arr[0] - arr[1]);
        for (int i = 1; i < arr.length; i++) {
            int currentMinDiff = Math.abs(arr[i] - arr[i - 1]);
            if (currentMinDiff == minDiff) {
                List<Integer> lst = new ArrayList<>();
                lst.add(arr[i - 1]);
                lst.add(arr[i]);
                res.add(lst);
            } else if (minDiff > currentMinDiff) {
                minDiff = currentMinDiff;
                List<Integer> lst = new ArrayList<>();
                lst.add(arr[i - 1]);
                lst.add(arr[i]);
                res = new ArrayList<>();
                res.add(lst);
            }
        }
        return res;
    }
}
