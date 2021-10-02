package Easy;

import base.Node;

//559. Maximum Depth of N-ary Tree
public class Solution559 {

    int max = 0;

    public int maxDepth(Node root) {
        process(root, 1);
        return max;
    }

    void process(Node node, int level) {
        if (node == null)
            return;
        if (level > max)
            max = level;
        if (node.children != null) {
            node.children.forEach(item -> {
                process(item, level + 1);
            });
        }
    }

}
