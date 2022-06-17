package Easy;

import java.util.HashMap;

//116. Populating Next Right Pointers in Each Node
public class Solution116 {
    public static void main(String[] args) {

        System.out.print("asdas");
    }

    public Node connect(Node root) {
        HashMap<Integer, Node> hm = new HashMap<>();
        populate(root, 0, hm);
        return root;
    }

    void populate(Node node, int h, HashMap<Integer, Node> hm) {
        if (node == null)
            return;
        node.next = hm.get(h);
        hm.put(h, node);
        populate(node.right, h + 1, hm);
        populate(node.left, h + 1, hm);
        hm.remove(h);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
