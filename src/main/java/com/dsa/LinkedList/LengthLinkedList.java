package com.dsa.LinkedList;

public class LengthLinkedList {

    static class Node
    {
        int data;
        Node next;

        Node(int data,Node next)
        {
            this.data = data;
            this.next = next;
        }

        Node()
        {
            this.data = 0;
            this.next = null;
        }

    }

    int solve(Node head)
    {
        int count =0;
        Node curr = head;
        while(curr!=null)
        {
            curr=curr.next;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        LengthLinkedList ll = new LengthLinkedList();

        // TEST CASE 1: Single node
        Node t1 = new Node(10, null);
        System.out.println("Test1 Length = " + ll.solve(t1)); // Expect 1

        // TEST CASE 2: Two nodes
        Node t2 = new Node(20, new Node(30, null));
        System.out.println("Test2 Length = " + ll.solve(t2)); // Expect 2

        // TEST CASE 3: Three nodes
        Node t3 = new Node(1, new Node(2, new Node(3, null)));
        System.out.println("Test3 Length = " + ll.solve(t3)); // Expect 3

        // TEST CASE 4: Null head (empty list)
        Node t4 = null;
        System.out.println("Test4 Length = " + ll.solve(t4)); // Expect 0

        // TEST CASE 5: Using default Node()
        Node t5 = new Node();
        System.out.println("Test5 Length = " + ll.solve(t5)); // Expect 1
    }

}
