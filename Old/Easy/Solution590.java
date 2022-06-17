package Easy;

import java.util.ArrayList;
import java.util.List;

//590. N-ary Tree Postorder Traversal
public class Solution590 {

    public List<Integer> postorder(Node root) {
        List<Integer> lst = new ArrayList<>();
        dfs(root, lst);
        return lst;
    }

    void dfs(Node node, List<Integer> lst) {
        if (node == null)
            return;
        lst.add(0, node.val);
        if (node.children != null) {
            for (int i = node.children.size()-1; i >= 0; i--) {
                dfs(node.children.get(i), lst);
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
