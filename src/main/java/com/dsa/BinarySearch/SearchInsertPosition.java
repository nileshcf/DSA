package com.dsa.BinarySearch;

public class SearchInsertPosition {

	int solve(int[] nums,int target){
		int ind= nums.length;
		int hi=nums.length-1;
		int low=0;
		while (low<=hi)
		{
			int mid= low+(hi-low)/2;
			if(nums[mid]>=target)
			{
				ind=mid;
				hi=mid-1;
			}
			else {
				low=mid+1;
			}
		}

		return ind;
	}

	public static void main(String[] args) {
		SearchInsertPosition s = new SearchInsertPosition();

		System.out.println(s.solve(new int[]{1,3,5,6}, 5)); // 2
		System.out.println(s.solve(new int[]{1,3,5,6}, 2)); // 1
		System.out.println(s.solve(new int[]{1,3,5,6}, 7)); // 4
		System.out.println(s.solve(new int[]{1,3,5,6}, 0)); // 0
	}
}
