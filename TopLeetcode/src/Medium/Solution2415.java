package Medium;

import BaseClasses.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/
public class Solution2415 {

    public TreeNode reverseOddLevels(TreeNode root) {

        var queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int h = 1;
        while (!queue.isEmpty()) {

            h++;
            int size = queue.size();

            while (size-- > 0) {
                var node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }

            if (h % 2 == 0) {

                int[] values = new int[queue.size()];

                int i = 0;
                for (var node : queue) {
                    values[i++] = node.val;
                }

                i--;
                for (var node : queue) {
                    node.val = values[i--];
                }

            }
        }

        return root;
    }


    public static void main(String[] args) {
        System.out.println(Math.log(16) / Math.log(2) % 2 == 0);
        System.out.println(Math.log(15) / Math.log(2) % 2 == 0);
        System.out.println(Math.log(17) / Math.log(2) % 2 == 0);
        System.out.println(Math.log(8) / Math.log(2) % 2 == 0);
    }

}
