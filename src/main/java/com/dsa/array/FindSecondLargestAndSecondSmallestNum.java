package com.dsa.array;


public class FindSecondLargestAndSecondSmallestNum {

    static int[] solution(int[] nums)
    {
        int small = Integer.MAX_VALUE, second_smallest = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE, second_max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max) {
                second_max = max;
                max = num;

            } else if (num > second_max && num != max) {
                second_max = max;
            }

            if (num < small) {
                second_smallest = small;
                small = num;

            } else if (num < second_smallest && num != small) {
                second_smallest = num;
            }
        }

        if(second_max==Integer.MIN_VALUE||second_smallest==Integer.MAX_VALUE)
         return new int[]{-1,-1} ;


        return new int[]{second_max,second_smallest};
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
            int[] result = solution(testCases[i]);
            System.out.println(
                    "Test case " + (i + 1) +
                            " -> Second Largest: " + result[0] +
                            ", Second Smallest: " + result[1]
            );
        }
    }


}
