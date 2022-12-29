package Medium;

import java.util.HashMap;
import java.util.HashSet;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return true;
    }

    public static void main(String[] args) {
        var app = new Solution98();
        var hm = new HashMap<Integer, HashSet<Integer>>();

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
    }
}
