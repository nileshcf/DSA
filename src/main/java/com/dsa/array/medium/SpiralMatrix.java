package com.dsa.array.medium;


import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {


	static List<Integer> solve(int[][] mat)
	{
		int top=0;
		int left=0;
		int right= mat[0].length-1;
		int bottom= mat.length-1;

		ArrayList<Integer> ans = new ArrayList<>();
		while (top<=bottom && left<=right)
		{
			for(int i=left;i<=right;i++)
			{
				ans.add(mat[top][i]);
			}

			top++;

			for (int i = top; i <= bottom; i++) {
				ans.add(mat[i][right]);
			}

			right--;

			for (int i = right; i >= left ; i--) {
				ans.add(mat[bottom][i]);
			}

			bottom--;

			for (int i = bottom; i >=top ; i--) {
				ans.add(mat[i][left]);
			}

			left++;

		}

		return ans;
	}

	public static void main(String[] args) {


		// Input matrix
		int[][] matrix = {
				{ 1,  2,  3,  4 },
				{ 5,  6,  7,  8 },
				{ 9, 10, 11, 12 },
				{ 13,14, 15, 16 }
		};


		System.out.println("--------------------");

		System.out.println(solve(matrix));

	}
}
