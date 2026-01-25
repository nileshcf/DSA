package com.dsa.LinkedList;

public class Node {

    int data;
    Node next;

    Node(int data,Node next)
    {
        this.data = data;
        this.next = next;
    }

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }


    public static void main(String[] args) {

        int[] arr = {2,4,8,9};
        Node node = new Node(arr[0]);

        System.out.println(node);
        System.out.println(node.data);
    }

}
