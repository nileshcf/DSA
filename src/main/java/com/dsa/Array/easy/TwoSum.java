package com.dsa.Array.easy;


import java.util.Arrays;

public class TwoSum {

	static boolean solve(int[] nums,int target)
	{
		Arrays.sort(nums);

		int left = 0, right = nums.length-1;
		int sum;
		while(left<right)
		{
			sum=nums[left]+nums[right];
			if(sum==target)
			{
				return true;
			} else if (sum<target) {
				left++;

			}
			else {
				right--;
			}
		}

		return false;

	}

	public static void main(String[] args) {

		int[][] testCases = {
				{2, 7, 11, 15},
				{3, 2, 4},
				{3, 3},
				{-1, 0, 1, 2},
				{1, 5, 3, 7},
				{1},
				{}
		};

		int[] targets = {9, 6, 6, 0, 10, 1, 0};

		for (int i = 0; i < testCases.length; i++) {
			int[] nums = testCases[i];
			int target = targets[i];

			System.out.println("Test case " + (i + 1));
			System.out.println("Array  : " + Arrays.toString(nums));
			System.out.println("Target : " + target);
			System.out.println("Result : " + solve(nums, target));
			System.out.println("----------------------------------");
		}
	}




}
