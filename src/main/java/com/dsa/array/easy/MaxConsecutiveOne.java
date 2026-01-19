package com.dsa.array.easy;


public class MaxConsecutiveOne {

    static int solve(int[] nums)
    {

        int currCount=0;
        int maxCount=0;

        for(int num:nums)
        {
            if(num==1)
            {
                currCount++;
                maxCount=Math.max(maxCount,currCount);
            }
            else {
                currCount=0;
            }

        }

        return maxCount;

    }


    public static void main(String[] args) {

        int[][] testCases = {
                {1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0},
                {1},
                {0},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {},
                {1, 1, 1, 1, 1, 1}
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = solve(testCases[i]);
            System.out.println("Test case " + (i + 1) + " result: " + result);
        }
    }


}
