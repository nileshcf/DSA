package com.dsa.LinkedList;



public class SortZeroOneTwo {

	Node solve(Node node)
	{

		Node dummyOne = new Node();
		Node dummyZero = new Node();
		Node dummyTwo = new Node();

		Node tailOne = dummyOne;
		Node tailTwo = dummyTwo;
		Node tailZero = dummyZero;

		while(node!=null)
		{
			if(node.data==0)
			{
				tailZero.next = new Node(0,null);
				tailZero= tailZero.next;
			} else if (node.data==1) {
				tailOne.next=new Node(1,null);
				tailOne= tailOne.next;

			}else {
				tailTwo.next = new Node(2,null);
				tailTwo= tailTwo.next;
			}

			node = node.next;
		}

		// Connect Zero -> One (or Two if One empty)
		if (dummyOne.next != null)
			tailZero.next = dummyOne.next;
		else
			tailZero.next = dummyTwo.next;

		// Connect One -> Two
		tailOne.next = dummyTwo.next;

		// ensure final list ends properly
		tailTwo.next = null;

		return dummyZero.next;
	}

	// only helper to print list
	static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		SortZeroOneTwo obj = new SortZeroOneTwo();

		// Test Case 1: Mixed
		Node t1 = new Node(2, new Node(1, new Node(0, new Node(2, new Node(1, new Node(0, null))))));
		System.out.print("Input 1:  ");
		printList(t1);
		Node r1 = obj.solve(t1);
		System.out.print("Output 1: ");
		printList(r1); // Expected: 0 0 1 1 2 2

		// Test Case 2: Already sorted
		Node t2 = new Node(0, new Node(0, new Node(1, new Node(1, new Node(2, new Node(2, null))))));
		System.out.print("Input 2:  ");
		printList(t2);
		Node r2 = obj.solve(t2);
		System.out.print("Output 2: ");
		printList(r2); // Expected: 0 0 1 1 2 2

		// Test Case 3: All zeros
		Node t3 = new Node(0, new Node(0, new Node(0, null)));
		System.out.print("Input 3:  ");
		printList(t3);
		Node r3 = obj.solve(t3);
		System.out.print("Output 3: ");
		printList(r3); // Expected: 0 0 0

		// Test Case 4: All ones
		Node t4 = new Node(1, new Node(1, new Node(1, null)));
		System.out.print("Input 4:  ");
		printList(t4);
		Node r4 = obj.solve(t4);
		System.out.print("Output 4: ");
		printList(r4); // Expected: 1 1 1

		// Test Case 5: All twos
		Node t5 = new Node(2, new Node(2, new Node(2, null)));
		System.out.print("Input 5:  ");
		printList(t5);
		Node r5 = obj.solve(t5);
		System.out.print("Output 5: ");
		printList(r5); // Expected: 2 2 2

		// Test Case 6: Single element
		Node t6 = new Node(1, null);
		System.out.print("Input 6:  ");
		printList(t6);
		Node r6 = obj.solve(t6);
		System.out.print("Output 6: ");
		printList(r6); // Expected: 1

		// Test Case 7: Empty list
		Node t7 = null;
		System.out.print("Input 7:  ");
		printList(t7);
		Node r7 = obj.solve(t7);
		System.out.print("Output 7: ");
		printList(r7); // Expected: (empty output)
	}
}
