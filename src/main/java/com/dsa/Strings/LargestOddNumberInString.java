package com.dsa.Strings;

public class LargestOddNumberInString {

	String solve(String number)
	{
		int i=0;

		while (i<=number.length()-1&&number.charAt(i)=='0')
			i++;


		int j = number.length()-1;
		while(j>=0&& (number.charAt(j)-'0')%2==0)
			j--;


		// no odd digit found
		if (j < 0)
			return "";

		// after removing zeros, nothing left
		if (i > j)
			return "";

		return number.substring(i, j + 1);
	}

	public static void main(String[] args) {

		LargestOddNumberInString obj = new LargestOddNumberInString();

		// TEST CASE 1
		String s1 = "5347";
		System.out.println("Input: " + s1 + " -> Output: " + obj.solve(s1));
		// Expected: 5347

		// TEST CASE 2
		String s2 = "0214638";
		System.out.println("Input: " + s2 + " -> Output: " + obj.solve(s2));
		// Expected: 21463

		// TEST CASE 3
		String s3 = "0000";
		System.out.println("Input: " + s3 + " -> Output: " + obj.solve(s3));
		// Expected: (empty)

		// TEST CASE 4
		String s4 = "4206";
		System.out.println("Input: " + s4 + " -> Output: " + obj.solve(s4));
		// Expected: (empty)

		// TEST CASE 5
		String s5 = "1050";
		System.out.println("Input: " + s5 + " -> Output: " + obj.solve(s5));
		// Expected: 105

		// TEST CASE 6
		String s6 = "00015";
		System.out.println("Input: " + s6 + " -> Output: " + obj.solve(s6));
		// Expected: 15

		// TEST CASE 7
		String s7 = "7";
		System.out.println("Input: " + s7 + " -> Output: " + obj.solve(s7));
		// Expected: 7

		// TEST CASE 8
		String s8 = "8";
		System.out.println("Input: " + s8 + " -> Output: " + obj.solve(s8));
		// Expected: (empty)
	}
}
