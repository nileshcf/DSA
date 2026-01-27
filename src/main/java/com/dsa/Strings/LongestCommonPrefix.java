package com.dsa.Strings;

import java.util.Arrays;

/**
 * Author: Nilesh Verma
 *
 */

public class LongestCommonPrefix {


	String solve(String[] words)
	{
		StringBuilder ans = new StringBuilder();
		Arrays.sort(words);

		for(int i =0;i<Math.min(words[0].length(),words[words.length-1].length());i++)
		{

			if(words[0].charAt(i)!=words[words.length-1].charAt(i))
			{
				return ans.toString();
			}

			ans.append(words[0].charAt(i));
		}

		return ans.toString();

	}

	public static void main(String[] args) {

		LongestCommonPrefix obj = new LongestCommonPrefix();

		// TEST CASE 1: Normal case
		String[] t1 = {"flower", "flow", "flight"};
		System.out.println("Input: " + Arrays.toString(t1));
		System.out.println("Output: " + obj.solve(t1));  // Expected: "fl"
		System.out.println();

		// TEST CASE 2: No common prefix
		String[] t2 = {"dog", "racecar", "car"};
		System.out.println("Input: " + Arrays.toString(t2));
		System.out.println("Output: " + obj.solve(t2));  // Expected: ""
		System.out.println();

		// TEST CASE 3: All identical
		String[] t3 = {"test", "test", "test"};
		System.out.println("Input: " + Arrays.toString(t3));
		System.out.println("Output: " + obj.solve(t3));  // Expected: "test"
		System.out.println();

		// TEST CASE 4: Single word
		String[] t4 = {"alone"};
		System.out.println("Input: " + Arrays.toString(t4));
		System.out.println("Output: " + obj.solve(t4));  // Expected: "alone"
		System.out.println();

		// TEST CASE 5: Contains empty string
		String[] t5 = {"", "abc", "abd"};
		System.out.println("Input: " + Arrays.toString(t5));
		System.out.println("Output: " + obj.solve(t5));  // Expected: ""
		System.out.println();

		// TEST CASE 6: Mixed-length common prefix
		String[] t6 = {"interview", "internet", "internal", "interval"};
		System.out.println("Input: " + Arrays.toString(t6));
		System.out.println("Output: " + obj.solve(t6));  // Expected: "inte"
	}


}
