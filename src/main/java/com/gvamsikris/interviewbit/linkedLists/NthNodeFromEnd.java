package com.gvamsikris.interviewbit.linkedLists;

public class NthNodeFromEnd {
    public static void main(String[] args) {
        NthNodeFromEnd fromEnd = new NthNodeFromEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(fromEnd.removeNthFromEnd(head, 2));
    }

    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode head = A;
        ListNode retVal = A;
        for (int i = 0; i < B; i++) {
            if (A != null) {
                A = A.next;
            }
        }
        if(A == null) {
            return retVal.next;
        }
        while (A.next != null) {
            head = head.next;
            A = A.next;
        }
        ListNode temp = head.next != null ? head.next.next : null;
        head.next = null;
        head.next = temp;
        return retVal;
    }
}
