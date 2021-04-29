package com.gvamsikris.interviewbit.linkedLists;

public class ListCycle {
    public ListNode detectCycle(ListNode a) {
        ListNode fast = a;
        ListNode slow = a;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                break;
            }
        }
        if(slow != fast) {
            return null;
        }
        slow = a;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
