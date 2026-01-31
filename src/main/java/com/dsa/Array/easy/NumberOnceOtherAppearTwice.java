package com.dsa.Array.easy;


import java.util.Arrays;

public class NumberOnceOtherAppearTwice {

	static int solve(int[] nums)
	{
		int xor=0;
		for(int num:nums)
		{
			xor^=num;
		}

		return xor;
	}
	public static void main(String[] args) {

		int[][] testCases = {
				{2, 2, 1},
				{4, 1, 2, 1, 2},
				{1},
				{7, 3, 5, 3, 5},
				{-1, -1, -2},
				{0, 0, 9},
				{10, 14, 10}
		};

		for (int i = 0; i < testCases.length; i++) {
			int[] nums = testCases[i];

			System.out.println("Test case " + (i + 1));
			System.out.println("Array: " + Arrays.toString(nums));
			System.out.println("Number appearing once: " + solve(nums));
			System.out.println("----------------------------------");
		}
	}

}
