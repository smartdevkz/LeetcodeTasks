package Easy;

import java.util.HashMap;

//993. Cousins in Binary Tree
public class Solution993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        HashMap<Integer, Pair> hm = new HashMap<>();
        dfs(root, hm, 0, null);
        return hm.get(x).height == hm.get(y).height && hm.get(x).parentVal != hm.get(y).parentVal;
    }

    void dfs(TreeNode node, HashMap<Integer, Pair> hm, int h, Integer parentVal) {
        if (node == null)
            return;
        hm.put(node.val, new Pair(h, parentVal));
        dfs(node.left, hm, h + 1, node.val);
        dfs(node.right, hm, h + 1, node.val);
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

    class Pair {
        public int height;
        public Integer parentVal;

        public Pair(int height, Integer parentVal) {
            this.parentVal = parentVal;
            this.height = height;
        }
    }
}
