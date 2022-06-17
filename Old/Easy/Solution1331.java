package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

//https://leetcode.com/problems/rank-transform-of-an-array/
public class Solution1331 {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0)
            return arr;
        int[] copy = Arrays.copyOf(arr, arr.length);

        HashMap<Integer, Integer> hm = new LinkedHashMap<>();
        Arrays.sort(arr);
        int k = 1;
        hm.put(arr[0], k);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                hm.put(arr[i], ++k);
            }
        }

        for (int i = 0; i < copy.length; i++) {
            copy[i] = hm.get(copy[i]);
        }

        return copy;
    }
}
