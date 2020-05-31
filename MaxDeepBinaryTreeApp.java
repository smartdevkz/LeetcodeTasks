public class MaxDeepBinaryTreeApp {

    public static void main(String[] args) {
        MaxDeepBinaryTreeApp app = new MaxDeepBinaryTreeApp();
        app.run();
    }

    void run() {

    }

    public int maxDepth(TreeNode root) {
        return getDepth(root, 1);
    }

    int getDepth(TreeNode node, int h) {
        if (node.left == null && node.right == null)
            return h;
        int leftDepth = node.left!=null? getDepth(node.left, ++h):-1;
        int rightDepth =node.right!=null? getDepth(node.right, ++h):-1;
        return leftDepth > rightDepth ? leftDepth : rightDepth;
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
}