package Easy;

import base.TreeNode;

//938. Range Sum of BST
public class Solution938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        if (root.val < low)
            return rangeSumBST(root.right, low, high);
        if (root.val > high)
            return rangeSumBST(root.left, low, high);
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}