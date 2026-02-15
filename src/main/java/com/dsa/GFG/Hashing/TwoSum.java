package com.dsa.GFG.Hashing;

import java.util.Arrays;

public class TwoSum {

	boolean solve(int[] arr,int num)
	{
		Arrays.sort(arr);
		int start=0,end= arr.length-1;
		while (start<end)
		{
			int sum=arr[start]+arr[end];
			if(sum==num)
				return true;
			else if (sum<num) {
				start++;
			}
			else  if (sum>num) {
				end--;
			}
		}

		return  false;
	}
}
