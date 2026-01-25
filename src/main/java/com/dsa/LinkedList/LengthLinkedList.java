package com.dsa.LinkedList;

public class LengthLinkedList {

    class Node
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
            this.data = Integer.parseInt(null);
            this.next = null;
        }

    }

    public static void main(String[] args) {

        Node node = new Node();
    }
}
