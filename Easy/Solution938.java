package Easy;

import base.TreeNode;

//938. Range Sum of BST
public class Solution938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.hight = high;
        dfs(root);
        return s;
    }

    int s = 0;
    int low, hight;

    void dfs(TreeNode node) {
        if (node == null)
            return;
        if (node.val >= low && node.val <= hight)
            s += node.val;
        dfs(node.left);
        dfs(node.right);
    }
}