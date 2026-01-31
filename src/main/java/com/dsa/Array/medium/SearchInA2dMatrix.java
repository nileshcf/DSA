package com.dsa.Array.medium;


import java.util.Arrays;

public class SearchInA2dMatrix {

	//2d Array is sorted
	static boolean solve(int[][] mat,int target)
	{

		int i;
		for (i = 0; i < mat.length; i++) {
			if(target<mat[i][mat[0].length-1])
			{
				break;
			}
		}

		if(i== mat.length)
			return false;

		for (int j = 0; j < mat[0].length; j++) {

			if(target==mat[i][j])
			{
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		int[][][] matrices = {
				{
						{1, 3, 5, 7},
						{10, 11, 16, 20},
						{23, 30, 34, 60}
				},
				{
						{1, 2, 3},
						{4, 5, 6}
				},
				{
						{5}
				},
				{
						{1, 4},
						{6, 8}
				}
		};

		int[] targets = {3, 5, 5, 7};

		for (int t = 0; t < matrices.length; t++) {
			int[][] mat = matrices[t];
			int target = targets[t];

			System.out.println("Test case " + (t + 1));
			System.out.println("Matrix:");
			for (int[] row : mat) {
				System.out.println(Arrays.toString(row));
			}
			System.out.println("Target: " + target);
			System.out.println("Found : " + solve(mat, target));
			System.out.println("----------------------------------");
		}
	}


}
