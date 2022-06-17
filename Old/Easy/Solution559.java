package Easy;

import base.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//559. Maximum Depth of N-ary Tree
public class Solution559 {

    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                current.children.forEach(item -> {
                    queue.offer(item);
                });
            }
            depth++;
        }

        return depth;
    }

}
