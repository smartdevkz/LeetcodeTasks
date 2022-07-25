package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/permutations-ii/
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (var n : nums) {
            int count = counter.containsKey(n) ? counter.get(n) : 0;
            counter.put(n, count + 1);
        }
        backtrack(new LinkedList<Integer>(), nums.length, counter, result);
        return result;
    }

    void backtrack(LinkedList<Integer> lst, int N, HashMap<Integer, Integer> counter, List<List<Integer>> result) {
        if (lst.size() == N) {
            result.add(new ArrayList<>(lst));
            return;
        }

        for (var entry : counter.entrySet()) {
            var n = entry.getKey();
            int count = entry.getValue();
            if (count == 0) continue;
            lst.addLast(n);
            counter.put(n, count - 1);
            backtrack(lst, N, counter, result);
            lst.removeLast();
            counter.put(n, count);
        }
    }
}
