package Medium;

//https://leetcode.com/problems/sort-list/

import BaseClasses.ListNode;

import java.util.List;

public class Solution148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        var mid = getMid(head);
        var left = sortList(head);
        var right = sortList(mid);
        return mergeSort(left, right);
    }

    private ListNode getMid(ListNode head) {
        var slow = head;
        var fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        var mid = slow;
        prev.next = null;
        return mid;
    }

    private ListNode mergeSort(ListNode list1, ListNode list2) {
        var dummyHead = new ListNode();
        var tail = dummyHead;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;

        }

        tail.next = list1 != null ? list1 : list2;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        var app = new Solution148();
        var lst1 = init(new int[]{1, 3});
        var lst2 = init(new int[]{0, 2});
        var res = app.mergeSort(lst1, lst2);
        display(res);
    }

    private static ListNode init(int[] arr) {
        ListNode node = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            int a = arr[i];
            node = new ListNode(a, node);
        }
        return node;
    }

    private static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("");
    }
}
