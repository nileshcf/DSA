package com.dsa.BinarySearch;

public class LowerBound {

	int solve(int[] nums, int target) {
		int low = 0;
		int hi = nums.length - 1;
		int ans = nums.length; // important fix

		while (low <= hi) {
			int mid = low + (hi - low) / 2;

			if (nums[mid] >= target) {
				ans = mid;
				hi = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		LowerBound lb = new LowerBound();

		int[] nums1 = {1, 2, 4, 4, 5};
		System.out.println(lb.solve(nums1, 4)); // Expected: 2

		int[] nums2 = {1, 2, 4, 4, 5};
		System.out.println(lb.solve(nums2, 3)); // Expected: 2

		int[] nums3 = {1, 2, 4, 4, 5};
		System.out.println(lb.solve(nums3, 6)); // Expected: 5

		int[] nums4 = {1, 2, 4, 4, 5};
		System.out.println(lb.solve(nums4, 0)); // Expected: 0

		int[] nums5 = {};
		System.out.println(lb.solve(nums5, 3)); // Expected: 0
	}
}
