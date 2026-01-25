package com.dsa.array.medium;


import java.util.Arrays;

//Logic
//Swap all i,j elements to j,i
// then swap all rows moving to center
public class RotateMatrix {

	static int[][] solve(int[][] mat)
	{
		int i,j,temp;
		for( i=0; i<mat.length; i++)
		{
			for ( j = i+1; j<mat[0].length; j++) {

				temp=mat[i][j];
				mat[i][j]=mat[j][i];
				mat[j][i]=temp;

			}
		}

		for (i=0;i<mat.length;i++)
		{
			reverseArray(mat[i]);
		}

		return mat;
	}

	static void reverseArray(int[] arr)
	{
		int t,l=0,r=arr.length-1;

		while(l<r)
		{
			t=arr[l];
			arr[l]=arr[r];
			arr[r]=t;

			l++;
			r--;
		}
	}

	// Helper to print matrix
	static void printMatrix(int[][] mat) {
		for (int[] row : mat) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
	}

	public static void main(String[] args) {

		// Test case 1: 3x3 matrix
		int[][] mat1 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};

		System.out.println("Test Case 1 - Before:");
		printMatrix(mat1);
		solve(mat1);
		System.out.println("After:");
		printMatrix(mat1);

		// Test case 2: 4x4 matrix
		int[][] mat2 = {
				{5, 1, 9, 11},
				{2, 4, 8, 10},
				{13, 3, 6, 7},
				{15, 14, 12, 16}
		};

		System.out.println("Test Case 2 - Before:");
		printMatrix(mat2);
		solve(mat2);
		System.out.println("After:");
		printMatrix(mat2);

		// Test case 3: 1x1 matrix
		int[][] mat3 = {
				{1}
		};

		System.out.println("Test Case 3 - Before:");
		printMatrix(mat3);
		solve(mat3);
		System.out.println("After:");
		printMatrix(mat3);
	}




}
