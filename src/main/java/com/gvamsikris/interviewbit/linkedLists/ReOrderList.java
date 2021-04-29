package com.gvamsikris.interviewbit.linkedLists;

import java.util.Stack;

public class ReOrderList {
    public static void main(String[] args) {
        int[] array1 =
                new int[] { 90, 94, 25, 51, 45, 29, 55, 63, 48, 27, 72, 10, 36, 68, 16, 20, 31, 7, 95, 70, 89, 23, 22, 9, 74, 71, 35, 5, 80, 11, 49,
                        92, 69, 6, 37, 84, 78, 28, 43, 64, 96, 57, 83, 13, 73, 97, 75, 59, 53, 52, 19, 18, 98, 12, 81, 24, 15, 60, 79, 34, 1, 54, 93,
                        65, 44, 4, 87, 14, 67, 26, 30, 77, 58, 85, 33, 21, 46, 82, 76, 88, 66, 101, 61, 47, 8 };
        int[] array = new int[] {1, 2, 3, 4};
        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }
        ReOrderList reOrderList = new ReOrderList();
        System.out.println(reOrderList.reorderList(head));
    }

    public  ListNode reverseList(ListNode root) {
        ListNode prev = null;

        ListNode curr = root;

        ListNode next = null;

        while (curr != null) {
            // System.out.println(curr.val);
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public ListNode reorderList(ListNode A) {


        if(A == null) return A;

        ListNode root = A;
        ListNode slow = root;
        ListNode fast = slow.next;
        while(fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middleNode = slow.next;
        slow.next = null;

        ListNode r = reverseList(middleNode);

        ListNode temp = root;

        while(temp!= null && r!= null) {
            ListNode next1 = temp.next;
            temp.next = r;
            ListNode rNext = r.next;
            r.next = next1;
            r = rNext;
            temp = next1;
        }

        return root;


    }
}
