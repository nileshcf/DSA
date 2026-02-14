package com.dsa.Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class CountGoodNumbers {

	static final int MOD = 1000000007;

	int solve(int n)
	{
		if(n==1)
			return 5;

		if(n%2==0)
		{
			return 4*solve(n-1)%MOD;
		}else
		{
			return 5*solve(n-1)%MOD;
		}
	}

	public static void main(String[] args) {

		CountGoodNumbers obj = new CountGoodNumbers();

		Scanner sc = new Scanner(System.in);

		// ===============================
		// 1️⃣ Taking a single integer
		// ===============================
		System.out.print("Enter n: ");
		int n = sc.nextInt();
		System.out.println("Good numbers count: " + obj.solve(n));

		// ===============================
		// 2️⃣ Taking input as String
		// ===============================
		System.out.print("\nEnter a string: ");
		String str = sc.next();
		System.out.println("You entered string: " + str);

		// ===============================
		// 3️⃣ Taking input as char
		// ===============================
		System.out.print("\nEnter a character: ");
		char ch = sc.next().charAt(0);
		System.out.println("You entered char: " + ch);

		// ===============================
		// 4️⃣ Taking multiple integers in one line
		// Example input: 1 2 3 4
		// ===============================
		System.out.print("\nEnter number of elements: ");
		int size = sc.nextInt();

		int[] arr = new int[size];
		System.out.println("Enter " + size + " integers:");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println("Array elements: " + Arrays.toString(arr));

		// ===============================
		// 5️⃣ Taking a full line (with spaces)
		// ===============================
		sc.nextLine(); // consume leftover newline
		System.out.print("\nEnter a full sentence: ");
		String sentence = sc.nextLine();
		System.out.println("You entered: " + sentence);

		// ===============================
		// 6️⃣ Taking input line-by-line (multiple lines)
		// ===============================
		System.out.print("\nEnter two integers in separate lines:\n");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("Sum = " + (a + b));

		sc.close();
	}
}
