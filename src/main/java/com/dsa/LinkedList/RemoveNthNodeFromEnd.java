package com.dsa.LinkedList;

/**
 * Author: Nilesh Verma
 * Created On: 22/1/2026
 */


public class RemoveNthNodeFromEnd {

	Node solve(Node head, int n)
	{
		if(head==null)
			return null;

		Node curr = head;
		int size=0;

		while (curr !=null)
		{
			size++;
			curr = curr.next;
		}

		// if n is greater than size, invalid request
		if (n > size)
			return null;

		// removing head
		if (n == size)
			return head.next;

		int indexToReach = size - n - 1; // node before the target
		curr = head;

		// move to node before the one to delete
		for (int i = 0; i < indexToReach; i++)
			curr = curr.next;

		// delete curr.next
		curr.next = curr.next.next;

		return head;
	}
	// helper print function
	static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		RemoveNthNodeFromEnd obj = new RemoveNthNodeFromEnd();

		// TEST CASE 1: Remove 2nd from end
		Node t1 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
		System.out.print("Input 1:  ");
		printList(t1);
		Node r1 = obj.solve(t1, 2);
		System.out.print("Output 1 (remove 2nd from end): ");
		printList(r1);  // expected: 1 2 3 5

		// TEST CASE 2: Remove head (n == size)
		Node t2 = new Node(10, new Node(20, new Node(30, null)));
		System.out.print("Input 2:  ");
		printList(t2);
		Node r2 = obj.solve(t2, 3);
		System.out.print("Output 2 (remove head): ");
		printList(r2); // expected: 20 30

		// TEST CASE 3: Remove last node
		Node t3 = new Node(7, new Node(8, new Node(9, null)));
		System.out.print("Input 3:  ");
		printList(t3);
		Node r3 = obj.solve(t3, 1);
		System.out.print("Output 3 (remove last): ");
		printList(r3); // expected: 7 8

		// TEST CASE 4: Only one node
		Node t4 = new Node(100, null);
		System.out.print("Input 4:  ");
		printList(t4);
		Node r4 = obj.solve(t4, 1);
		System.out.print("Output 4 (remove sole node): ");
		printList(r4); // expected: (empty output)

		// TEST CASE 5: n > size (invalid)
		Node t5 = new Node(5, new Node(6, null));
		System.out.print("Input 5:  ");
		printList(t5);
		Node r5 = obj.solve(t5, 5);
		System.out.print("Output 5 (invalid n): ");
		printList(r5); // expected: null (empty output)
	}



}
