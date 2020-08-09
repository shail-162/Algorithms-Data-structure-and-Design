package linkedList;


import library.LinkedListNode;

/**
 * Definition for singly-linked list.
 * class LinkedListNode {
 * public int val;
 * public LinkedListNode next;
 * LinkedListNode(int x) { val = x; next = null; }
 * }
 * A : [ 630 -> 624 -> 85 -> 955 -> 757 -> 841 -> 967 -> 377 -> 932 ]
 * B : 2
 */
public class KthFromMiddleLinkedList {

    public static int solve(ListNode A, int B) {
        //find middle
        ListNode fast = A;
        ListNode slow = A;
        int middle = 0;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            middle++;
        }
        System.out.println("middle = " + middle + ", middle val = " +  slow.val);
        int move = middle - B;
        if (move == 0) {
            return A.val;
        }

        if (move < 0) {
            return -1;
        }

        while (move > 0) {
            A = A.next;
            move--;
        }

        return A != null ? A.val : -1;
    }

    public static void main(String args[]){
        ListNode lA1 = new ListNode(630);
        ListNode lA2 = new ListNode(624);
        lA1.next = lA2;
        ListNode lA3 = new ListNode(85);
        lA2.next = lA3;
        ListNode lA4 = new ListNode(955);
        lA3.next = lA4;
        ListNode lA5 = new ListNode(757);
        lA4.next = lA5;
        ListNode lA6 = new ListNode(841);
        lA5.next = lA6;
        ListNode lA7 = new ListNode(967);
        lA6.next = lA7;
        ListNode lA8 = new ListNode(377);
        lA7.next = lA8;
        ListNode lA9 = new ListNode(932);
        lA8.next = lA9;
        lA1.printForward();

        int result = solve(lA1, 3);

        System.out.println("result " + result);
    }
}
