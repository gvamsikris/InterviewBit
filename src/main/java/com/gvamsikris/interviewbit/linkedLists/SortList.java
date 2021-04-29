package com.gvamsikris.interviewbit.linkedLists;

public class SortList {
    public ListNode findMiddle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode middle = findMiddle(A);
        ListNode middleNext = middle.next;
        middle.next = null;
        ListNode left = sortList(A);
        ListNode right = sortList(middleNext);
        return mergeSort(left, right);
    }

    private ListNode mergeSort(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode result = null;
        if (left.val <= right.val) {
            result = left;
            left.next = mergeSort(left.next, right);
        }
        if (right.val < left.val) {
            result = right;
            right.next = mergeSort(left, right.next);
        }
        return result;
    }
}
