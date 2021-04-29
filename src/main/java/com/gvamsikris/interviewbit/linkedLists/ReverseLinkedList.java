package com.gvamsikris.interviewbit.linkedLists;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode A) {
        ListNode prev = null;
        ListNode current = A;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
