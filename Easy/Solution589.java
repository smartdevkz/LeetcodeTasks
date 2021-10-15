package Easy;

import java.util.ArrayList;
import java.util.List;

//589. N-ary Tree Preorder Traversal
public class Solution589 {
    public List<Integer> preorder(Node root) {
        List<Integer> lst = new ArrayList<>();
        dfs(root, lst);
        return lst;
    }

    void dfs(Node node, List<Integer> lst) {
        if (node == null)
            return;
        lst.add(node.val);
        if (node.children != null) {
            for (var child : node.children) {
                dfs(child, lst);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
