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
          while(temp!=null){
              System.out.print("->" + temp.val );
              temp = temp.next;
          }
          System.out.println();
      }
  }