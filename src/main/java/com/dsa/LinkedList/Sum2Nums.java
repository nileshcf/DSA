package com.dsa.LinkedList;



public class Sum2Nums {

	Node solve(Node node1,Node node2)
	{
		Node ans = new Node(0, null);
		Node tail =ans;
		int carry=0;
		while (node1!=null || node2!=null || carry!=0)
		{
			int x = (node1!=null) ? node1.data:0;
			int y = (node2!=null) ? node2.data:0;

			int currsum = x+y+carry;

			carry=currsum/10;
			currsum%=10;

			tail.next = new Node(currsum,null);
			tail= tail.next;

			node1 = (node1!=null) ? node1.next:null;
			node2 = (node2!=null) ? node2.next:null;

		}

		return ans.next;
	}
	// helper to print list
	static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Sum2Nums obj = new Sum2Nums();

		// TEST CASE 1: Simple addition (342 + 465 = 807)
		Node a1 = new Node(2, new Node(4, new Node(3, null))); // number = 342
		Node b1 = new Node(5, new Node(6, new Node(4, null))); // number = 465
		Node res1 = obj.solve(a1, b1);
		System.out.print("Test1 (342 + 465): ");
		printList(res1); // Expected: 7 0 8

		// TEST CASE 2: Different lengths (99 + 1 = 100)
		Node a2 = new Node(9, new Node(9, null)); // number = 99
		Node b2 = new Node(1, null);              // number = 1
		Node res2 = obj.solve(a2, b2);
		System.out.print("Test2 (99 + 1): ");
		printList(res2); // Expected: 0 0 1

		// TEST CASE 3: Single digit (5 + 7 = 12)
		Node a3 = new Node(5, null);
		Node b3 = new Node(7, null);
		Node res3 = obj.solve(a3, b3);
		System.out.print("Test3 (5 + 7): ");
		printList(res3); // Expected: 2 1

		// TEST CASE 4: One list null (0 + 123 = 123)
		Node a4 = null;
		Node b4 = new Node(3, new Node(2, new Node(1, null))); // number = 123
		Node res4 = obj.solve(a4, b4);
		System.out.print("Test4 (0 + 123): ");
		printList(res4); // Expected: 3 2 1

		// TEST CASE 5: Both null (0 + 0 = 0)
		Node a5 = null;
		Node b5 = null;
		Node res5 = obj.solve(a5, b5);
		System.out.print("Test5 (0 + 0): ");
		printList(res5); // Expected: 0
	}

}
