package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        bfs(root, 0, result);
        return result;
    }

    void bfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;
        if (result.size() < level + 1) result.add(new LinkedList<Integer>());
        result.get(level).add(node.val);
        bfs(node.left, level + 1, result);
        bfs(node.right, level + 1, result);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
