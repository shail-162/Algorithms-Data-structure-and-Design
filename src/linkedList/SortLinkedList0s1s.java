package linkedList;

/**
 *   0 -> 0 -> 1 -> 1 -> 0
 *  *
 *  *  1 -> 0 -> 0 -> 1
 *
 *  0 -> 1 -> 0 -> 1 -> 0
 *  0 -> 1 -> 0 -> 1 -> 0 -> 0 -> 1 -> 1 -> 0
 * @author Shailesh
 */
public class SortLinkedList0s1s {

    public static void main(String args[]){
        ListNode lA1 = new ListNode(0);
        ListNode lA2 = new ListNode(1);
        lA1.next = lA2;
        ListNode lA3 = new ListNode(0);
        lA2.next = lA3;
        ListNode lA4 = new ListNode(1);
        lA3.next = lA4;
        ListNode lA5 = new ListNode(0);
        lA4.next = lA5;
        ListNode lA6 = new ListNode(0);
        lA5.next = lA6;
        ListNode lA7 = new ListNode(1);
        lA6.next = lA7;
        ListNode lA8 = new ListNode(1);
        lA7.next = lA8;
        ListNode lA9 = new ListNode(0);
        lA8.next = lA9;
        lA1.printForward();

        ListNode result = sort(lA1);

        result.printForward();
    }

    public static ListNode sort(ListNode node){
        ListNode a = node;
        ListNode b = node;

        while (a!=null && b!=null){

            if(a.val==0 && b.val==0){
                a = a.next;
                b = b.next;
                continue;
            } else if(b.val==1 && a.val == 1){
                a = a.next;
            }

            if(a!=null && a.val==0){
                int temp = a.val;
                a.val = b.val;
                b.val =temp;

                b = b.next;
                a = a.next;
            }
        }

        return node;
    }
}
