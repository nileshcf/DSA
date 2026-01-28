package com.dsa.Strings.sectionOne;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Nilesh Verma
 **/

public class IsomorphicStrings {


	boolean solve(String first, String second)
	{
		if(first.length()!=second.length())
			return false;

		int[] firstCount = new int[256];
		int[] secondCount = new int[256];

		for (int i=0;i<first.length();i++)
		{
			if(firstCount[first.charAt(i)]== secondCount[second.charAt(i)])
			{
				firstCount[first.charAt(i)]=i+1;
				secondCount[second.charAt(i)]=i+1;
			}
			else {
				return false;
			}
		}

		return true;

 	}

	 boolean solveWithMap(String first, String second)
	 {
		 if(first.length()!=second.length())
			 return false;

		 Map<Character,Character> firstMap = new HashMap<Character,Character>();
		 Map<Character,Character> secondMap = new HashMap<Character,Character>();

		 for (int i=0;i<first.length();i++)
		 {
			 char f=first.charAt(i);
			 char s=second.charAt(i);

			if(firstMap.containsKey(f) && firstMap.get(f)!=s)
				return false;

			 if(secondMap.containsKey(s) && secondMap.get(s)!=f)
				 return false;

			 firstMap.put(f,s);
			 secondMap.put(s,f);

		 }

		 return true;


	 }

	// ---- MAIN WITH TEST CASES ----
	public static void main(String[] args) {
		IsomorphicStrings obj = new IsomorphicStrings();

		String[][] tests = {
				{"egg", "add"},    // true
				{"foo", "bar"},    // false
				{"paper", "title"},// true
				{"ab", "cc"},      // false
				{"aab", "xxy"},    // true
				{"aab", "xyz"},    // false
				{"", ""},          // true
				{"abc", "def"},    // true
				{"abc", "dee"}     // false
		};

		System.out.println("TESTING USING ARRAY INDEX METHOD:");
		for (String[] t : tests) {
			System.out.println(Arrays.toString(t) + " -> " + obj.solve(t[0], t[1]));
		}

		System.out.println("\nTESTING USING MAP METHOD:");
		for (String[] t : tests) {
			System.out.println(Arrays.toString(t) + " -> " + obj.solveWithMap(t[0], t[1]));
		}
	}

}
