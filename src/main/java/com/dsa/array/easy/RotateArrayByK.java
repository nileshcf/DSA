package com.dsa.array.easy;

import java.util.Arrays;

public class RotateArrayByK {

    static void solve(int[] nums, int k, String side) {

        // Step 1: Handle cases where k > array length
        // Rotating n times gives original array
        k = k % nums.length;

        if (side.equalsIgnoreCase("right")) {

            /*
             RIGHT ROTATION LOGIC (by k steps)

             Example:
             nums = [1,2,3,4,5], k = 2

             Step 1: Reverse whole array
                     [5,4,3,2,1]

             Step 2: Reverse first k elements
                     [4,5,3,2,1]

             Step 3: Reverse remaining elements
                     [4,5,1,2,3]  ← final result
            */

            reverseArray(nums, 0, nums.length - 1); // reverse entire array
            reverseArray(nums, 0, k - 1);           // reverse first k elements
            reverseArray(nums, k, nums.length - 1); // reverse remaining elements

        } else {

            /*
             LEFT ROTATION LOGIC (by k steps)

             Example:
             nums = [1,2,3,4,5], k = 2

             Step 1: Reverse whole array
                     [5,4,3,2,1]

             Step 2: Reverse first n-k elements
                     [2,3,4,5,1]

             Step 3: Reverse last k elements
                     [3,4,5,1,2]  ← final result
            */

            reverseArray(nums, 0, nums.length - 1);          // reverse entire array
            reverseArray(nums, 0, nums.length - k - 1);      // reverse first n-k elements
            reverseArray(nums, nums.length - k, nums.length - 1); // reverse last k elements
        }
    }

    // Helper function to reverse part of the array
    static void reverseArray(int[] nums, int start, int end) {

        // Swap elements from both ends moving inward
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Main method with multiple test cases
    public static void main(String[] args) {

        int[][] testCases = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1},
                {1, 2}
        };

        int[] ks = {2, 2, 7, 3, 1};
        String[] sides = {"right", "left", "right", "right", "left"};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1));
            System.out.println("Before: " + Arrays.toString(testCases[i]));

            // Arrays are passed by reference in Java
            solve(testCases[i], ks[i], sides[i]);

            System.out.println("After (" + sides[i] + " rotate by " + ks[i] + "): "
                    + Arrays.toString(testCases[i]));
            System.out.println("-----------------------------------");
        }
    }
}
