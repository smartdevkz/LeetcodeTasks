package Medium;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/sort-characters-by-frequency/
public class Solution451 {

    public String frequencySort(String s) {

        HashMap<Character, Integer> hm = new HashMap<>();

        for (Character c : s.toCharArray()) {
            var count = hm.getOrDefault(c, 0) + 1;
            hm.put(c, count);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(hm.entrySet());


        var result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            var c = maxHeap.remove();
            for (int i = 0; i < c.getValue(); i++) {
                result.append(c.getKey());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        var app = new Solution451();
        var res = app.frequencySort("raaeaedere");
        System.out.println(res);
    }
}
