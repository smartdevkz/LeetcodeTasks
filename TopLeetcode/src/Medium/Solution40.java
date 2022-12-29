package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
public class Solution40 {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(0, target, new LinkedList<>(), candidates);
        return result;
    }

    void backtrack(int idx, int n, LinkedList<Integer> lst, int[] candidates) {
        if (n == 0) {
            result.add(new ArrayList<>(lst));
            return;
        }
        if (n < 0 || idx == candidates.length) return;
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i - 1] == candidates[i]) {
                continue;
            }
            int c = candidates[i];
            //if(n-c<0)break;
            lst.add(c);
            backtrack(i + 1, n - c, lst, candidates);
            lst.removeLast();
        }
    }

    public static void main(String[] args) {
        var arr = new int[]{10, 1, 2, 7, 6, 1, 5};
        var app = new Solution40();
        var res = app.combinationSum2(arr, 8);
    }

}
