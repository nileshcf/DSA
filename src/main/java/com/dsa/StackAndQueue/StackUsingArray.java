package com.dsa.StackAndQueue;

import java.util.Arrays;
public class StackUsingArray {

	static class ArrayStack {
		int[] stack;
		int capacity;
		int top = -1;

		ArrayStack(int capacity) {
			this.capacity = capacity;
			stack = new int[capacity];
		}

		void push(int n) {
			if (top == capacity - 1) {
				System.out.println("Stack Overflow");
				return;
			}
			stack[++top] = n;
		}

		int pop() {
			if (top == -1) {
				System.out.println("Stack Underflow");
				return -1;
			}
			return stack[top--];
		}

		int peek() {
			if (top == -1) {
				System.out.println("Stack is Empty");
				return -1;
			}
			return stack[top];
		}

		boolean isEmpty() {
			return top == -1;
		}
	}

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(3);

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40); // Overflow

		System.out.println(stack.pop()); // 30
		System.out.println(stack.pop()); // 20
		System.out.println(stack.peek()); // 10
		System.out.println(stack.pop()); // 10
		System.out.println(stack.pop()); // Underflow
	}
}
