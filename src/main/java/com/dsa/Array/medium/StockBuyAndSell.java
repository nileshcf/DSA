package com.dsa.Array.medium;


public class StockBuyAndSell {

	static int solve(int[] arr)
	{
		int maxDiff=0,currMin=Integer.MAX_VALUE;

		for(int i:arr)
		{
			if(currMin>i)
			{
				currMin=i;
			}

			maxDiff=Math.max(maxDiff,i-currMin);
		}

		return maxDiff;
	}
	public static void main(String[] args) {

		// Test Case 1
		int[] arr1 = {7, 1, 5, 3, 6, 4};
		System.out.println("Max Profit: " + solve(arr1)); // Expected: 5

		// Test Case 2
		int[] arr2 = {7, 6, 4, 3, 1};
		System.out.println("Max Profit: " + solve(arr2)); // Expected: 0

		// Test Case 3
		int[] arr3 = {1, 2, 3, 4, 5};
		System.out.println("Max Profit: " + solve(arr3)); // Expected: 4

		// Test Case 4 (single element)
		int[] arr4 = {5};
		System.out.println("Max Profit: " + solve(arr4)); // Expected: 0

		// Test Case 5 (same prices)
		int[] arr5 = {3, 3, 3, 3};
		System.out.println("Max Profit: " + solve(arr5)); // Expected: 0
	}
}
