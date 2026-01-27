package com.dsa.LinkedList;

/**
 * Author: Nilesh Verma
 *
 */

public class ReverseLinkedList {

	Node solve(Node head)
	{
		Node prev = null;
		Node curr=head;

		while(curr!=null)
		{
			Node temp = curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}

		return prev;

	}

	// helper to print a list
	static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		ReverseLinkedList obj = new ReverseLinkedList();

		// TEST CASE 1: Multiple nodes
		Node t1 = new Node(1, new Node(2, new Node(3, new Node(4, null))));
		System.out.print("Input 1:  ");
		printList(t1);
		Node r1 = obj.solve(t1);
		System.out.print("Output 1: ");
		printList(r1); // Expected: 4 3 2 1

		// TEST CASE 2: Two nodes
		Node t2 = new Node(10, new Node(20, null));
		System.out.print("Input 2:  ");
		printList(t2);
		Node r2 = obj.solve(t2);
		System.out.print("Output 2: ");
		printList(r2); // Expected: 20 10

		// TEST CASE 3: Single node
		Node t3 = new Node(99, null);
		System.out.print("Input 3:  ");
		printList(t3);
		Node r3 = obj.solve(t3);
		System.out.print("Output 3: ");
		printList(r3); // Expected: 99

		// TEST CASE 4: Empty list
		Node t4 = null;
		System.out.print("Input 4:  ");
		printList(t4);
		Node r4 = obj.solve(t4);
		System.out.print("Output 4: ");
		printList(r4); // Expected: (empty)
	}

}
