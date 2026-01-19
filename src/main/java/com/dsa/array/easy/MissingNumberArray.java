package com.dsa.array.easy;


import java.util.Arrays;

public class MissingNumberArray {

	static int solve(int[] nums, int n)
	{
//		XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
//		XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a. ←Property 2

		int xor1=0,xor2=0;

		for(int i=0;i<n-1;i++)
		{
			xor1^=nums[i];
			xor2^=i+1;
		}

		xor2^=n;
		return xor1^xor2;

	}

	public static void main(String[] args) {

		int[][] testCases = {
				{1, 2, 4, 5},      // missing 3
				{1, 2, 3, 5},      // missing 4
				{2, 3, 4, 5},      // missing 1
				{1, 2, 3, 4},      // missing 5
				{1},               // missing 2
				{2},               // missing 1
				{}                 // missing 1
		};

		int[] nValues = {5, 5, 5, 5, 2, 2, 1};

		for (int i = 0; i < testCases.length; i++) {
			int[] nums = testCases[i];
			int n = nValues[i];

			System.out.println("Test case " + (i + 1));
			System.out.println("Array: " + Arrays.toString(nums));
			System.out.println("n = " + n);

			int missing = solve(nums, n);
			System.out.println("Missing number: " + missing);
			System.out.println("----------------------------------");
		}
	}

}
