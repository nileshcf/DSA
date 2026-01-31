package com.dsa.BinarySearch;

/**
 * Author: Nilesh Verma
 *
 */

public class BinarySearch {

	boolean search(int[] nums,  int target)
	{
		int hi=nums.length-1;
		int low=0;

		while (low<=hi)
		{
			int mid=(low)+(hi-low)/2;
			if(nums[mid]==target)return true;
			if (nums[mid]<target)
				low=mid+1;
			else hi=mid-1;
		}

		return false;
	}


	public static void main(String[] args) {

		BinarySearch obj = new BinarySearch();

		// TEST CASE 1: target present
		int[] nums1 = {1, 3, 5, 7, 9};
		System.out.println(obj.search(nums1, 5)); // true

		// TEST CASE 2: target absent
		int[] nums2 = {2, 4, 6, 8};
		System.out.println(obj.search(nums2, 5)); // false

		// TEST CASE 3: single element (found)
		int[] nums3 = {10};
		System.out.println(obj.search(nums3, 10)); // true

		// TEST CASE 4: single element (not found)
		int[] nums4 = {10};
		System.out.println(obj.search(nums4, 5)); // false

		// TEST CASE 5: empty array
		int[] nums5 = {};
		System.out.println(obj.search(nums5, 1)); // false
	}
}
