package Medium;

import BaseClasses.TreeNode;

//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
public class Solution1315 {

    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        traverse(root);
        return sum;
    }

    private void traverse(TreeNode node) {

        if (node == null) return;

        if (node.val % 2 == 0) {
            sum += getChildrenValueSum(node.left) + getChildrenValueSum(node.right);
        }

        traverse(node.left);
        traverse(node.right);
    }

    private int getChildrenValueSum(TreeNode node) {
        if (node == null) return 0;
        return (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);
    }
}
