package Easy;

import java.util.ArrayList;
import java.util.List;

import base.TreeNode;

//897. Increasing Order Search Tree
public class Solution897 {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        process(root, lst);
        TreeNode current = null;
        for(int i=lst.size()-1;i>=0;i--){
            if (current == null) {
                current = new TreeNode(lst.get(i), null, null);
            } else {
                current = new TreeNode(lst.get(i), null, current);
            }
        }
        for (Integer item : lst) {
            if (current == null) {
                current = new TreeNode(item, null, null);
            } else {
                current = new TreeNode(item, null, current);
            }
        }
        return current;
    }

    void process(TreeNode node, List<Integer> lst) {
        if (node == null)
            return;

        if (node.left != null) {
            process(node.left, lst);
        }

        lst.add(node.val);

        if (node.right != null) {
            process(node.right, lst);
        }
        node = null;
    }

}