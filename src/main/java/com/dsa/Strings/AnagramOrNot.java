package com.dsa.Strings;

public class AnagramOrNot {

	boolean solve(String first, String second)
	{
		if(first.length()!=second.length())
			return false;

		int[] count = new int[26];

		for (int i = 0; i < first.length(); i++) {

			count[first.charAt(i)-'a']++;
		}

		for (int i = 0; i < second.length(); i++) {

			count[second.charAt(i)-'a']--;

		}

		for(int val:count)
		{
			if(val!=0)
				return false;
		}

		return true;

	}

	public static void main(String[] args) {
		AnagramOrNot obj = new AnagramOrNot();

		System.out.println(obj.solve("listen", "silent"));  // true
		System.out.println(obj.solve("triangle", "integral")); // true
		System.out.println(obj.solve("anagram", "nagaram")); // true
		System.out.println(obj.solve("rat", "car"));  // false
		System.out.println(obj.solve("aab", "abb"));  // false
		System.out.println(obj.solve("abc", "abcd")); // false
	}

}
