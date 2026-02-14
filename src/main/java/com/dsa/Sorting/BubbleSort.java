package com.dsa.Sorting;

public class BubbleSort {

	void solve(int[] arr)
	{
		for(int i=0;i<arr.length-2;i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {

				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		BubbleSort b = new BubbleSort();

	}
}
