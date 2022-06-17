package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution818 {
    public static void main(String[] args) {
        var app = new Solution818();
        var res = app.racecar2(330);
        System.out.println(res);
    }

    int target;

    public int racecar(int target) {
        this.target = target;
        var lst = new ArrayList<Node>();
        //lst.add(new Node(0, 1));
        int count = getCount(lst, 0);
        return count;
    }

    public int racecar2(int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 1, 0));
        int pos = 0;
        while (pos != target) {
            var item = queue.poll();
            if (item.pos == target) {
                return item.count;
            } else {
                queue.add(new Node(item.pos + item.speed, item.speed * 2, item.count + 1));
                queue.add(new Node(item.pos, item.speed > 0 ? -1 : 1, item.count + 1));
            }
        }
        return 0;
    }

    public int getCount(List<Node> lst, int count) {
        var newList = new ArrayList<Node>();
        for (var item : lst) {
            if (item.pos == target) {
                return count;
            } else {
                //newList.add(new Node(item.pos + item.speed, item.speed * 2));
                //newList.add(new Node(item.pos, item.speed > 0 ? -1 : 1));
            }
        }
        lst = null;
        return getCount(newList, ++count);
    }

    public class Node {
        public Node(int pos, int speed, int count) {
            this.pos = pos;
            this.speed = speed;
            this.count = count;
        }

        public int pos;
        public int speed;
        public int count;
    }
}
