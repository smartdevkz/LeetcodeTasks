package Easy;

import java.util.ArrayList;
import java.util.List;

//94. Binary Tree Inorder Traversal
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        preorder(root, lst);
        return lst;
    }

    void preorder(TreeNode node, List<Integer> lst) {
        if (node == null)
            return;
        preorder(node.left, lst);
        lst.add(node.val);
        preorder(node.right, lst);
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
