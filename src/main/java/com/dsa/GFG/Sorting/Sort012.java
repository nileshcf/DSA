package com.dsa.GFG.Sorting;



public class Sort012 {

	void solve(int[]arr)
	{
		int low=0,mid=0,high=arr.length-1;

		while (mid<=high)
		{
			if(arr[mid]==0)
			{
				swap(arr,low,mid);
				low++;
				mid++;
			}else if(arr[mid]==1)
			{
				mid++;

			}else  if(arr[mid]==2)
			{
				swap(arr,mid,high);
				high--;
			}
		}

	}

	void swap(int[]arr,int a,int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}

	public static void main(String[] args) {
		Sort012 s = new Sort012();
		int[] arr1 = {0,1,0,0,2,0,2};
		s.solve(arr1);
		System.out.println("Sorted array "+java.util.Arrays.toString(arr1));
	}
}
