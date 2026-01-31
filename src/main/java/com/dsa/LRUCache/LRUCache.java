package com.dsa.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	public class Node{
		int key,value;
		Node prev,next;

		Node(int k, int v)
		{
			this.key=k;
			this.value=v;
		}
	}

	private Map<Integer,Node> map;
	private int capacity;
	Node head,tail;

	LRUCache(int capacity)
	{
		head = new Node(0,0);
		tail = new Node(0,0);
		this.capacity = capacity;
		map = new HashMap<>();
		head.next = tail;
		tail.prev = head;
	}

	int get(int key)
	{
		if(!map.containsKey(key))
		{
			System.out.println("Key Not Found\n");
			return -1;
		}

		Node curr = map.get(key);
		removeNode(curr);
		insertAtHead(curr);

		return curr.value;
	}

	void put(int key,int value)
	{

		//TODO this is a logic i Forgot
		if(map.containsKey(key))
		{
			Node curr = map.get(key);
			curr.value=value;
			removeNode(curr);
			insertAtHead(curr);
			return;
		}

		if(map.size()==capacity)
		{
			Node lru = tail.prev;
			removeNode(lru);
			map.remove(lru);

		}

		Node node = new Node(key,value);
		insertAtHead(node);
		map.put(key,node);
		return;
	}


	void removeNode(Node node)
	{
		node.next.prev=node.prev;
		node.prev.next=node.next;
	}

	void insertAtHead(Node node)
	{
		head.next.prev=node;
		node.next=head.next;
		head.next=node;
		node.prev=head;
	}

	// ---------------- TEST ----------------
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);

		cache.put(1, 10);
		cache.put(2, 20);
		System.out.println(cache.get(1)); // 10

		cache.put(3, 30); // evicts key 2
		System.out.println(cache.get(2)); // -1

		cache.put(4, 40); // evicts key 1
		System.out.println(cache.get(1)); // -1
		System.out.println(cache.get(3)); // 30
		System.out.println(cache.get(4)); // 40
	}
}
