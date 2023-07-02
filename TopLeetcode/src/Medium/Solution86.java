package Medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/partition-list/
public class Solution86 {

    public ListNode partition(ListNode head, int x) {

        ListNode before_head = new ListNode(0);
        var before = before_head;
        ListNode after_head = new ListNode(0);
        var after = after_head;

        while (head != null) {

            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        after.next = null;
        before.next = after_head.next;

        return before_head.next;
    }

    public static void main(String[] args) {
        var app = new Solution86();
        var head = app.getNode(List.of(4, 3, 1, 2));
        app.test(head);

    }

    public ListNode getNode(List<Integer> lst) {
        ListNode node = null;
        for (int i = lst.size() - 1; i >= 0; i--) {
            if (node != null) {
                node = new ListNode(lst.get(i), node);
            } else {
                node = new ListNode(lst.get(i), null);
            }
        }
        return node;
    }

    public void test(ListNode head) {
        var node = head;
        while (node != null) {
            node = new ListNode(1, null);
            node = node.next;
        }
        var t = 1;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


