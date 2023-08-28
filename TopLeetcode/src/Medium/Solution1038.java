package Medium;

import BaseClasses.TreeNode;

//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
public class Solution1038 {

    public TreeNode bstToGst(TreeNode root) {
        getSum(root);
        return root;
    }

    public int getSum(TreeNode node) {

        if (node == null) return 0;

        node.val = node.val + getSum(node.right);

        if (node.left != null) {
            var left = node.left;
            left.val = left.val + node.val + getSum(node.left.right);
        }

        return node.val;
    }

}
