package com.dsa.array.basic;

import java.util.ArrayList;
import java.util.Arrays;

public class LeftRotateByOne {

    static int[] solve(int[] nums)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        //TODO TOLEARN
        // int [] -> ArrayList()
//      ArrayList<Integer> list = Arrays.stream(arr)
//                .boxed()
//                .collect(Collectors.toCollection(ArrayList::new));

        for(int num : nums)
        {
            arrayList.add(num);
        }

        int first = arrayList.getFirst();
        arrayList.removeFirst();
        arrayList.add(first);

        return arrayList.stream().mapToInt(Integer::intValue).toArray();

    }

    static int[] optimisedSolve(int[] nums)
    {
        if(nums.length==0)
            return  new int[0];

        if(nums.length==1)
            return  new int[]{nums[0]};

        int firstnum=nums[0];

        for(int i=0;i<nums.length-1;i++)
        {
            nums[i]=nums[i+1];
        }

        nums[nums.length-1]=firstnum;

        return nums;
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
            int[] result = optimisedSolve(testCases[i]);
            System.out.println(
                    "Test case " + (i) +
                            " -> Number found: " + Arrays.toString(result));
        }
    }

}
