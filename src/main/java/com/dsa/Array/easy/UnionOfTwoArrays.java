package com.dsa.Array.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class UnionOfTwoArrays {

	// Arrays are sorted
	//Two pointer methods
	static int[] solve(int[] nums1, int[] nums2) {

		ArrayList<Integer> unionNums = new ArrayList<>();
		int i = 0, j = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				unionNums.add(nums1[i]);
				i++;
			} else if(nums2[j]<nums1[i]){
				unionNums.add(nums2[j]);
				j++;
			}
			else {
				unionNums.add(nums1[i]);
				i++;j++;
			}
		}

		while (i < nums1.length) unionNums.add(nums1[i++]);
		while (j < nums2.length) unionNums.add(nums2[j++]);


		// Note: remaining elements are NOT handled in your logic
		return unionNums.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {

		int[][] nums1Cases = {
				{1, 3, 5},
				{1, 2, 3},
				{2, 4, 6},
				{},
				{1, 1, 2}
		};

		int[][] nums2Cases = {
				{2, 4, 6},
				{4, 5, 6},
				{1, 3, 5},
				{1, 2, 3},
				{2, 3, 4}
		};

		for (int i = 0; i < nums1Cases.length; i++) {

			int[] nums1 = nums1Cases[i];
			int[] nums2 = nums2Cases[i];

			System.out.println("Test case " + (i + 1));
			System.out.println("Array 1: " + Arrays.toString(nums1));
			System.out.println("Array 2: " + Arrays.toString(nums2));

			int[] result = solve(nums1, nums2);
			System.out.println("Union   : " + Arrays.toString(result));
			System.out.println("----------------------------------");
		}
	}
}
