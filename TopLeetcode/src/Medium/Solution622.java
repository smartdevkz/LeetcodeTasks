package Medium;

import java.util.ArrayList;

//https://leetcode.com/problems/design-circular-queue/
public class Solution622 {
    class MyCircularQueue {

        private int size = 0;
        private ArrayList<Integer> items;

        public MyCircularQueue(int k) {
            this.size = k;
            items = new ArrayList<>();
        }

        //Inserts an element into the circular queue. Return true if the operation is successful.
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            items.add(value);
            return true;
        }

        // Deletes an element from the circular queue. Return true if the operation is successful.
        public boolean deQueue() {
            if (isEmpty()) return false;
            items.remove(0);
            return true;
        }

        //Gets the front item from the queue. If the queue is empty, return -1.
        public int Front() {
            if (isEmpty()) return -1;
            return items.get(0);
        }

        // Gets the last item from the queue. If the queue is empty, return -1.
        public int Rear() {
            if (isEmpty()) return -1;
            return items.get(items.size() - 1);
        }

        public boolean isEmpty() {
            return items.isEmpty();
        }

        public boolean isFull() {
            return items.size() == size;
        }

        public void display() {
            System.out.println(items);
        }
    }

    public void run() {
        var q = new MyCircularQueue(8);
        System.out.println(q.enQueue(3));
        System.out.println(q.enQueue(9));
        System.out.println(q.enQueue(5));
        System.out.println(q.enQueue(0));
        q.display();
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        q.display();
        System.out.println(q.isEmpty());
        System.out.println(q.isEmpty());
        System.out.println(q.Rear());
        System.out.println(q.Rear());
        System.out.println(q.deQueue());
        q.display();
    }

    public static void main(String[] args) {
        var app = new Solution622();
        app.run();
    }
}
