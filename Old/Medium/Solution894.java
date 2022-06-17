package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import base.TreeNode;

//https://leetcode.com/problems/all-possible-full-binary-trees/
public class Solution894 {
    public List<TreeNode> allPossibleFBT(int n) {
        return null;
    }

    HashMap<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> solve(int n) {
        if (n <= 0 || n % 2 == 0)
            return List.of();
        if (n == 1) {
            return List.of(new TreeNode(0));
        }
        var memoVal = memo.getOrDefault(n, null);
        if (memoVal != null)
            return memoVal;

        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            var leftTreeNodes = solve(i);
            var rightTreeNodes = solve(n - i - 1);
            for (var l : leftTreeNodes) {
                for (var r : rightTreeNodes) {
                    res.add(new TreeNode(0, l, r));
                }
            }
        }
        memo.put(n, res);
        return res;
    }

    public List<TreeNode> solve2(int n) {
        if (n < 2)
            return null;
        List<TreeNode> lst = new ArrayList<>();
        var arr = solve(n - 2);
        if (arr == null)
            return List.of(new TreeNode(0));

        for (var item : arr) {
            lst.add(new TreeNode(0, item, new TreeNode(0)));
            lst.add(new TreeNode(0, new TreeNode(0), item));
        }
        return lst;
    }
}
