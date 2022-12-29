package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
class Solution39 {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        backtrack(0, target, new LinkedList<>(), candidates);
        return result;
    }

    void backtrack(int idx, int n, LinkedList<Integer> lst, int[] candidates) {
        if (n == 0) {
            result.add(new ArrayList<>(lst));
            return;
        }
        if (n < 0) return;
        for (int i = idx; i < candidates.length; i++) {
            int c = candidates[i];
            int diff = n - c;
            lst.add(c);
            backtrack(i, diff, lst, candidates);
            lst.removeLast();
        }
    }

    public static void main(String[] args) {
        var app = new Solution39();
        var res = app.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}