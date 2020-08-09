package linkedList.Q2_05_Sum_Lists;

import library.LinkedListNode;

/**
 * @author shailesh
 */
public class AddTwoLinkedList {

    public static LinkedListNode addTwoNumbers(LinkedListNode A, LinkedListNode B) {
        LinkedListNode result = null;
        int carry = 0;
        LinkedListNode temp =null;

        while (A!=null || B!=null){
            int val1 = A!=null? A.data: 0;
            int val2 = B!=null ? B.data : 0;

            int sum = val1+ val2 + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum%10;

            if(result == null){
                temp = new LinkedListNode(sum);
                result = temp;
            } else {
                temp.next = new LinkedListNode(sum);
                temp = temp.next;
            }

            if (A!=null)
                A = A.next;
            if (B!=null)
                B = B.next;
        }

        if (carry > 0){
            temp.next = new LinkedListNode(carry);
        }

        return result;
    }

    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(3, null, null);
        LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(8, null, lA2);

        LinkedListNode lB1 = new LinkedListNode(5, null, null);
        LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(1, null, lB2);

        LinkedListNode list3 = addTwoNumbers(lA1, lB1);

        System.out.println("  " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        System.out.println("= " + list3.printForward());

    }
}
