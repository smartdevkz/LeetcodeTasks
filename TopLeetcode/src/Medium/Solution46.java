package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

//https://leetcode.com/problems/permutations/
public class Solution46 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        solve(new ArrayList<>(), nums);
        return res;
    }

    void solve(List<Integer> hs, int[] nums) {
        if (hs.size() == nums.length) {
            res.add(hs);
            return;
        }

        for (int n : nums) {
            if (hs.contains(n)) {
                continue;
            } else {
                var newHs = new ArrayList<>(hs);
                newHs.add(n);
                solve(newHs, nums);
            }
        }
    }

    public static void main(String[] args) {
        var app = new Solution46();
        var res = app.permute(new int[]{1, 2, 3});
        System.out.println(res);
    }
}
