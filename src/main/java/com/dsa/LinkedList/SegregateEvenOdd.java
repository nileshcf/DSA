package com.dsa.LinkedList;



public class SegregateEvenOdd {

	Node solve(Node node)
	{
		Node dummyEven= new Node();
		Node dummyOdd = new Node();
		Node ansodd = dummyOdd;
		Node anseven = dummyEven;


		while(node!=null)
		{
			if(node.data%2==0)
			{
				anseven.next = new Node(node.data,null);
				anseven= anseven.next;

			}else
			{
				ansodd.next = new Node(node.data,null);
				ansodd=ansodd.next;

			}
			node = node.next;
		}

		ansodd.next = dummyEven.next;


		return dummyOdd.next;
	}

	// helper print function (no Node changes)
	static void printList(Node head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		SegregateEvenOdd obj = new SegregateEvenOdd();

		// TEST CASE 1: Mixed
		Node t1 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
		System.out.print("Input 1:  ");
		printList(t1);
		Node r1 = obj.solve(t1);
		System.out.print("Output 1: ");
		printList(r1); // Expect: odd then even → 1 3 5 2 4

		// TEST CASE 2: All even
		Node t2 = new Node(2, new Node(8, new Node(6, null)));
		System.out.print("Input 2:  ");
		printList(t2);
		Node r2 = obj.solve(t2);
		System.out.print("Output 2: ");
		printList(r2); // Expect: 2 8 6

		// TEST CASE 3: All odd
		Node t3 = new Node(1, new Node(3, new Node(7, null)));
		System.out.print("Input 3:  ");
		printList(t3);
		Node r3 = obj.solve(t3);
		System.out.print("Output 3: ");
		printList(r3); // Expect: 1 3 7

		// TEST CASE 4: Single element (odd)
		Node t4 = new Node(5, null);
		System.out.print("Input 4:  ");
		printList(t4);
		Node r4 = obj.solve(t4);
		System.out.print("Output 4: ");
		printList(r4); // Expect: 5

		// TEST CASE 5: Single element (even)
		Node t5 = new Node(10, null);
		System.out.print("Input 5:  ");
		printList(t5);
		Node r5 = obj.solve(t5);
		System.out.print("Output 5: ");
		printList(r5); // Expect: 10

		// TEST CASE 6: Empty list
		Node t6 = null;
		System.out.print("Input 6:  ");
		printList(t6);
		Node r6 = obj.solve(t6);
		System.out.print("Output 6: ");
		printList(r6); // Expect: (empty)
	}

}
