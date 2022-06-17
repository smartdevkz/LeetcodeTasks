package Easy;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//783. Minimum Distance Between BST Nodes
public class Solution783 {
    public int minDiffInBST(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> lst = new ArrayList<>();
        while (!queue.isEmpty()) {
            var node = queue.poll();
            lst.add(node.val);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

        Collections.sort(lst);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lst.size() - 1; i++) {
            min = Math.min(min, lst.get(i + 1) - lst.get(i));
        }

        return min;
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
