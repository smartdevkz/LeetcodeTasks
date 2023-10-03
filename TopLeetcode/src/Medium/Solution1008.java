package Medium;

import BaseClasses.TreeNode;
import com.sun.jdi.connect.Connector;

public class Solution1008 {

    int[] preorder;
    int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {

        this.preorder = preorder;

        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private TreeNode helper(int lower, int upper) {
        if (idx >= preorder.length) return null;
        int val = preorder[idx];

        if (val < lower || val > upper) {
            return null;
        }
        idx++;

        var node = new TreeNode(val);
        node.left = helper(lower, val);
        node.right = helper(val, upper);

        return node;
    }

    public static void main(String[] args) {
        var app = new Solution1008();
        var res = app.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        var stop = 1;
    }
}
