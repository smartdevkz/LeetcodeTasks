package Medium;

import java.util.HashMap;
import java.util.PriorityQueue;

//https://leetcode.com/problems/smallest-number-in-infinite-set/
public class Solution2336 {
    public static void main(String[] args) {
        var s = new SmallestInfiniteSet();
        s.addBack(2);
        print(s.popSmallest());
        print(s.popSmallest());
        print(s.popSmallest());
        s.addBack(1);
        print(s.popSmallest());
        print(s.popSmallest());
        print(s.popSmallest());
    }

    static void print(int n) {
        System.out.println(n);
    }
}

class SmallestInfiniteSet {

    private PriorityQueue<Integer> minHeap = null;
    private int start = 1;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
    }

    public int popSmallest() {
        Integer num = minHeap.peek();
        if (num != null) return minHeap.poll();
        return start++;
    }

    public void addBack(int num) {
        if (!minHeap.contains(num) && num < start) {
            minHeap.add(num);
        }
    }
}
