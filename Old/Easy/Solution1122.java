package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

//https://leetcode.com/problems/relative-sort-array/
public class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hm = new LinkedHashMap<>();
        for (int item : arr2) {
            hm.put(item, 0);
        }
        List<Integer> lst = new ArrayList<>();
        for (var item : arr1) {
            if (hm.containsKey(item)) {
                hm.put(item, hm.get(item) + 1);
            } else {
                lst.add(item);
            }
        }
        arr1 = new int[arr1.length];
        Collections.sort(lst);

        int k = 0;
        for (int number : hm.keySet()) {
            for (int i = 0; i < hm.get(number); i++) {
                arr1[k] = number;
                k++;
            }
        }

        for (var number : lst) {
            arr1[k] = number;
            k++;
        }

        return arr1;
    }
}
