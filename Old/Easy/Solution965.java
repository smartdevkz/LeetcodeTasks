package Easy;

//965. Univalued Binary Tree
public class Solution965 {
    public boolean isUnivalTree(TreeNode root) {
        boolean left = root.left == null || (root.left.val == root.val && isUnivalTree(root.left));
        if (!left)
            return left;
        boolean right = root.right == null || (root.right.val == root.val && isUnivalTree(root.right));
        return left && right;
    }
}
