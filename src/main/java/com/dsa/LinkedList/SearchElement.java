package com.dsa.LinkedList;


public class SearchElement {

	boolean solve(Node head,int target)
	{
		Node curr = head;
		while(curr!=null)
		{
			if(curr.data==target)
				return true;
			curr=curr.next;

		}

		return false;
	}

	public static void main(String[] args) {

			SearchElement se = new SearchElement();

			// TEST CASE 1: Found at head
			Node t1 = new Node(10, new Node(20, new Node(30, null)));
			System.out.println("Test1 (10 present): " + se.solve(t1, 10)); // Expect true

			// TEST CASE 2: Found in middle
			Node t2 = new Node(5, new Node(15, new Node(25, null)));
			System.out.println("Test2 (15 present): " + se.solve(t2, 15)); // Expect true

			// TEST CASE 3: Found at tail
			Node t3 = new Node(7, new Node(14, new Node(21, null)));
			System.out.println("Test3 (21 present): " + se.solve(t3, 21)); // Expect true

			// TEST CASE 4: Not found
			Node t4 = new Node(1, new Node(2, new Node(3, null)));
			System.out.println("Test4 (99 not present): " + se.solve(t4, 99)); // Expect false

			// TEST CASE 5: Empty list
			Node t5 = null;
			System.out.println("Test5 (empty list): " + se.solve(t5, 10)); // Expect false

			// TEST CASE 6: Default node
			Node t6 = new Node();
			System.out.println("Test6 (0 present in default): " + se.solve(t6, 0)); // Expect true
		}

	}


