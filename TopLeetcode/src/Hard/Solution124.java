package Hard;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class Solution124 {
    int result = 0;

    public int maxPathSum(TreeNode root) {
        this.result = root.val;

        int v = root.val;
        int sum = v;
        if (root.left != null) {
            int l = solve(root.left);
            result = max(result, l, v, l + v);
            sum += l;
        }
        if (root.right != null) {
            int r = solve(root.right);
            result = max(result, r, r + v);
            sum += r;
        }

        return max(result, sum);
    }

    int solve(TreeNode node) {
        if (node == null) return 0;
        int left = solve(node.left);
        int right = solve(node.right);
        int val = node.val;
        int max = max(left + val, right + val, val, 0);
        int sum = left + val + right;
        this.result = max(this.result, sum, max);
        return max;
    }

    int max(int... values) {
        int max = values[0];
        for (int i : values) {
            max = Math.max(max, i);
        }
        return max;
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

    public TreeNode init() {
        return new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    }

    public static void main(String[] args) {
        var app = new Solution124();
        var root = app.init();
        int res = app.maxPathSum(root);
        System.out.println(res);
    }
}


