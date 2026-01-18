package com.dsa.array;

public class LinearSearch {

    static boolean solve(int[] nums, int target)
    {

        for(int num:nums)
        {
            if(num==target)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                {1, 2, 3, 4, 5},          // normal case
                {5, 4, 3, 2, 1},          // reverse order
                {10, 10, 10, 10},         // all same values
                {1, 1, 2, 2, 3, 3},       // duplicates
                {Integer.MIN_VALUE, 0, Integer.MAX_VALUE},
                {2},                      // single element
                {},                       // empty array
                {-5, -1, -3, -4},         // all negatives
                {7, 7, 8, 9},             // repeated max
                {1, 2}                    // minimal valid case
        };

        for (int i = 0; i < testCases.length; i++) {
            boolean result = solve(testCases[i],i);
            System.out.println(
                    "Test case " + (i + 1) +
                            " -> Number found: " + result );
        }
    }

}
