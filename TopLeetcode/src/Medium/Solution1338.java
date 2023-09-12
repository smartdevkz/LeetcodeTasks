package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/reduce-array-size-to-the-half/
public class Solution1338 {

    public int minSetSize(int[] arr) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int a : arr) {
            int count = hm.getOrDefault(a, 0);
            hm.put(a, count + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(hm.entrySet());

        int result = 0;
        int size = 0;

        while (!maxHeap.isEmpty() && size < arr.length / 2) {
            var a = maxHeap.remove();
            size += a.getValue();
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        var app = new Solution1338();
        int res = app.minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7});
        System.out.println(res);
    }

}
