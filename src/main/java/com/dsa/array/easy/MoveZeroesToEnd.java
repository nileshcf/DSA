package com.dsa.array.easy;


import java.util.Arrays;

public class MoveZeroesToEnd {

    static void solve(int[] nums)
    {
        int index=0;
            for (int i = 0; i < nums.length; i++) {

                if(nums[i]!=0)
                {
                    nums[index++]=nums[i];
                }
            }

            while(index< nums.length)
            {
                nums[index++]=0;
            }

    }
    public static void main(String[] args) {

        int[][] testCases = {
                {0, 1, 0, 3, 12},     // mixed
                {1, 2, 3, 4},         // no zeros
                {0, 0, 0, 0},         // all zeros
                {1, 0, 2, 0, 3, 0},   // alternating
                {},                   // empty array
                {0},                  // single zero
                {5},                  // single non-zero
                {0, 0, 1}             // zeros at start
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test case " + (i + 1));
            System.out.println("Before: " + Arrays.toString(testCases[i]));

            solve(testCases[i]);   // passed by reference

            System.out.println("After:  " + Arrays.toString(testCases[i]));
            System.out.println("----------------------------------");
        }
    }


}
