package com.dsa.array;


public class FindLargest {

    int largestNum(int[] arr)
    {
        int largestNumber=0;
        for (int j : arr) {
            if (j > largestNumber)
                largestNumber = j;
        }

        return largestNumber;
    }
}
