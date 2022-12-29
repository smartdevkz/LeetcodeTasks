package Hard;

import java.util.Stack;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        var st = new Stack<TreeNode>();
        st.push(root);
        TreeNode head = null;

        while (!st.empty()) {
            var tmp = st.pop();
            if (tmp.right != null) {
                st.push(tmp.right);
            }
            if (tmp.left != null) {
                st.push(tmp.left);
            }

            if (head == null) {
                head = tmp;
            } else {
                head.right = tmp;
                head = head.right;
            }
            head.left = null;
        }
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


