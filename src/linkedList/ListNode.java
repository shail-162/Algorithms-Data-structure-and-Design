package linkedList;

import java.util.List;

public class ListNode {
      public int val;
      public ListNode next;

      public ListNode(int x) {
          val = x;
          next = null;
      }

      public void printForward(){
          ListNode temp = this;
          do
          {
              System.out.print(temp.val + " ");
              temp = temp.next;
          }  while (temp != this);
          System.out.println();
      }


    public void printCircularLLForward(){
        ListNode curr = this;
        ListNode prev = curr;
        while(curr != prev.next){
            System.out.print("->" + curr.val );
            curr = curr.next;
            prev = curr;
        }
        System.out.println();
    }
  }