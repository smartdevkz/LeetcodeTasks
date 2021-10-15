package Easy;

import java.util.ArrayList;
import java.util.List;

//145. Binary Tree Postorder Traversal
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        preorder(root, lst);
        return lst;
    }

    void preorder(TreeNode node, List<Integer> lst) {
        if (node == null)
            return;
        lst.add(0, node.val);
        preorder(node.right, lst);
        preorder(node.left, lst);
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
