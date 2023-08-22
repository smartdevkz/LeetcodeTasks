package Medium;

import java.util.TreeMap;

//https://leetcode.com/problems/my-calendar-i/
public class Solution729 {

    public void run() {
        var calendar = new MyCalendar();
        System.out.println(calendar.book(37, 50));
        System.out.println(calendar.book(33, 50));
        System.out.println(calendar.book(4, 17));
        System.out.println(calendar.book(35, 48));
        System.out.println(calendar.book(8, 25));
    }

    public static void main(String[] args) {
        var app = new Solution729();
        app.run();
    }

    class MyCalendar {

        private TreeMap<Integer, Integer> treeMap = null;

        public MyCalendar() {
            treeMap = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            if (!treeMap.containsKey(start)) {
                treeMap.put(start, end);
            } else {
                return false;
            }

            var prev = treeMap.floorEntry(start - 1);
            if (prev != null) {
                if (prev.getValue() > start) {
                    treeMap.remove(start);
                    return false;
                }
            }

            var next = treeMap.ceilingEntry(start + 1);
            if (next != null) {
                if (end > next.getKey()) {
                    treeMap.remove(start);
                    return false;
                }
            }
            return true;
        }
    }
}
