package com.gvamsikris.interviewbit.linkedLists;

public class RotateList {
    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        int[] array =
                new int[] { 23, 57, 65, 90, 56, 69, 77, 52, 71, 74, 15, 25, 41, 17, 76, 95, 58, 38, 29, 68, 4, 89, 55, 99, 13, 92, 98, 62, 36, 59, 54,
                        48, 53, 12, 11, 6, 2, 35, 46, 39, 20, 27, 44, 78, 82, 67, 91, 64, 97, 43, 84, 83, 70, 73, 79, 88, 16, 1, 96, 66, 80, 72, 10,
                        19, 100, 33, 75, 3, 81, 24, 22, 87, 63, 9, 7, 40, 8, 34, 101, 60, 28 };
        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }
        System.out.println(rotateList.rotateRight(head, 20));
    }

    public ListNode rotateRight(ListNode A, int B) {
        ListNode tail = null;
        ListNode temp = A;
        int length = 0;
        while (temp != null) {
            tail = temp;
            temp = temp.next;
            length++;
        }
        B = B % length;
        B = Math.abs(length - B);
        tail.next = A;
        temp = A;
        ListNode prev = null;
        for (int i = 0; i < B; i++) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        return temp;
    }
}
