package com.gvamsikris.interviewbit.linkedLists;

public class ListNode {

    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }
}
