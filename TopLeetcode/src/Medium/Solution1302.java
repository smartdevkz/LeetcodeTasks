package Medium;

//https://leetcode.com/problems/deepest-leaves-sum/
public class Solution1302 {

    int result = 0;
    int h = 0;

    public int deepestLeavesSum(Solution102.TreeNode root) {

        int h = findDepth(root);

        traverse(root, 0);

        return result;
    }

    private int findDepth(Solution102.TreeNode node) {
        if (node == null) {
            return 0;
        }

        var leftDepth = findDepth(node.left);
        var rightDepth = findDepth(node.right);

        return Math.max(leftDepth, rightDepth) + 1;

    }

    private void traverse(Solution102.TreeNode node, int k) {
        if (node == null) return;

        if (node.left == null && node.right == null && k == h) {
            result += node.val;
        }

        traverse(node.left, k + 1);
        traverse(node.right, k + 1);
    }

}
