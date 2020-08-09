package linkedList.Q2_04_Partition;

import library.LinkedListNode;

/**
 *  WAC to partition a LL around a value x, such that all nodes less than x come before all nodes greater than
 *  or equal to x.
 *  If x is contained within the list, the values of x only need to be after the elements less than x.
 *  The partition element
 *  x can appear anywhere in the right partition, it does not need to appear between the left and right parenthesis.
 *  Ex: Input:  3->5->8->5->10->2->1 Partition 5
 *  	O/P :   3 ->1 -> 2 -> 10 -> 5 -> 5 -> 8
 */

/**
 * Solution :
 */
public class Partition {

    public static LinkedListNode partition(LinkedListNode head, int x) {
        LinkedListNode first = head;
        LinkedListNode second = head;

        while (second != null){

            if (second.data >= x){
                second = second.next;
            } else {
                if (first!=second){
                    int data = first.data;
                    first.data = second.data;
                    second.data = data;
                }
                second = second.next;
                first = first.next;

            }
        }

        return head;
    }

    public static void main(String[] args) {
        int length = 8;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());

        LinkedListNode h = partition(head, 2);
        System.out.println(h.printForward());
    }
}
