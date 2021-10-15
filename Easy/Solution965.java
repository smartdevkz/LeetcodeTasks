package Easy;

//965. Univalued Binary Tree
public class Solution965 {
    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }

    boolean dfs(TreeNode node, int n) {
        if (node == null)
            return true;
        if (node.val != n)
            return false;
        var left = dfs(node.left, n);
        if (!left)
            return false;
        var right = dfs(node.right, n);
        if (!right)
            return false;
        return true;
    }
}
