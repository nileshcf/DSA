package com.dsa.Array.easy;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	static void solve(int[] nums) {
		int index = 1;//very important bug

		for (int i = 1; i < nums.length; i++) {

			// If new element is found then add it to the same array
			if (nums[i - 1] != nums[i]) {
				nums[index++] = nums[i];
			}
		}
	}

	public static void main(String[] args) {

		int[][] testCases = {
				{1, 1, 2, 2, 3},
				{1, 1, 1, 1},
				{1, 2, 3, 4},
				{2, 2, 2, 3, 3, 4},
				{-1, -1, 0, 0, 1},
				{5},
				{}
		};

		for (int i = 0; i < testCases.length; i++) {
			int[] nums = testCases[i];

			System.out.println("Test case " + (i + 1));
			System.out.println("Before: " + Arrays.toString(nums));

			if (nums.length > 0) {
				solve(nums);
			}

			System.out.println("After : " + Arrays.toString(nums));
			System.out.println("----------------------------------");
		}
	}
}
