package com.dsa.array.medium;


import java.util.ArrayList;
import java.util.Arrays;

public class LeaderInArray
{
	static int[] solve(int[] arr)
	{
		int currMax=Integer.MIN_VALUE;
		ArrayList<Integer> ans= new ArrayList<>();
		for (int j = arr.length-1; j>= 0 ; j--) {

			if(arr[j]>currMax)
			{
				ans.add(arr[j]);
				currMax=arr[j];
			}

		}

		return ans.stream().mapToInt(Integer::intValue).toArray();


	}

	public static void main(String[] args) {

		int[][] testCases = {
				{4, 7, 1, 0},
				{10, 22, 12, 3, 0, 6},
				{5, 4, 3, 2, 1},
				{1, 2, 3, 4, 5},
				{7},
				{},
				{-1, -2, -3}
		};

		for (int i = 0; i < testCases.length; i++) {

			int[] arr = testCases[i];

			System.out.println("Test case " + (i + 1));
			System.out.println("Array  : " + Arrays.toString(arr));
			System.out.println("Leaders: " + Arrays.toString(solve(arr)));
			System.out.println("----------------------------------");
		}
	}

}
