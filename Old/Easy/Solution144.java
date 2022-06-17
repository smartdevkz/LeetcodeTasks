package Easy;

import java.util.ArrayList;
import java.util.List;

//144. Binary Tree Preorder Traversal
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        preorder(root, lst);
        return lst;
    }

    void preorder(TreeNode node, List<Integer> lst) {
        if (node == null)
            return;
        lst.add(node.val);
        preorder(node.left, lst);
        preorder(node.right, lst);
    }

    class TreeNode {
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
