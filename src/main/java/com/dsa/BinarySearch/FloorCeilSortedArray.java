package com.dsa.BinarySearch;

public class FloorCeilSortedArray {

	int[] solve(int[] nums,int target)
	{
		int[] ans = new int[2];
		int mid,low=0,hi= nums.length-1;

		while (low<=hi)
		{
			mid=low+(hi-low)/2;

			if(nums[mid]>=target)
			{
				ans[0]=nums[mid-1];
				ans[1]=nums[mid+1];
				hi=mid-1;
			}else
			{
				low=mid+1;
			}
		}

		return ans;
	}
}
