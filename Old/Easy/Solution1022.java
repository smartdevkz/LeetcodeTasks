package Easy;

//1022. Sum of Root To Leaf Binary Numbers
public class Solution1022 {

    public static void main(String[] args) {
        var app = new Solution1022();
        var root = app.getTest();
        var res = app.sumRootToLeaf(root);
        System.out.println(res);
    }

    public int sumRootToLeaf(TreeNode root) {
        return getSum(root, 0);
    }

    int getSum(TreeNode node, int sum) {
        if (node == null)
            return sum;
        sum = 2 * sum + node.val;
        if (node.left == null && node.right == null)
            return sum;
        int newSum = 0;
        if (node.left != null) {
            newSum += getSum(node.left, sum);
        }
        if (node.right != null) {
            newSum += getSum(node.right, sum);
        }
        return newSum;
    }

    TreeNode getTest() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0, 0, 1);
        root.right = new TreeNode(1, 0, 1);
        return root;
    }
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

    TreeNode(int val, int leftVal, int rightVal) {
        this.val = val;
        this.left = new TreeNode(leftVal);
        this.right = new TreeNode(rightVal);
    }
}