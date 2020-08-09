package linkedList;

import library.AssortedMethods;
import library.LinkedListNode;

public class DeleteMiddleofLinkedList {

	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false; // Failure
		} 
		LinkedListNode next = n.next; 
		n.data = next.data; 
		n.next = next.next; 
		return true;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(9, 0, 100);
		System.out.println(head.printForward());
		LinkedListNode middle = findMiddleOfLinkedList(head);
		System.out.println("middle= "+ middle.data);
		deleteNode(middle); // delete node 4
		System.out.println(head.printForward());
	}

	public static LinkedListNode findMiddleOfLinkedList(LinkedListNode node){
		if (node == null){
			return null;
		}

		LinkedListNode slow = node;
		LinkedListNode fast = node;

		while (slow!=null && fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

}
