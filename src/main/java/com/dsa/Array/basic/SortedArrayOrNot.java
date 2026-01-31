package com.dsa.Array.basic;


public class SortedArrayOrNot {

    boolean checkForSortedArray(int[] nums)
    {

        for(int i=1;i< nums.length;i++)
        {
            if(nums[i-1]>nums[i])
                return false;
        }

        return true;
    }


        public static void main(String[] args) {
            int[] arr = {1, 2, 7, 3, 4, 5};
            int n = 5;
            SortedArrayOrNot obj = new SortedArrayOrNot();

            boolean ans = obj.checkForSortedArray(arr);

            // Output result
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
}
