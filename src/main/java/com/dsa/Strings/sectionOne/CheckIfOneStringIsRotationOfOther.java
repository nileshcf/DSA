package com.dsa.Strings.sectionOne;

public class CheckIfOneStringIsRotationOfOther {

	boolean solve(String rotated, String target)
	{

		if (rotated.length() != target.length())
			return false;

		rotated +=rotated;

		for(int i=0;i<=rotated.length()-target.length();i++)
		{
			if(target.equals(rotated.substring(i,i+target.length())))
			{
				return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		CheckIfOneStringIsRotationOfOther obj = new CheckIfOneStringIsRotationOfOther();

		System.out.println(obj.solve("abcde", "cdeab")); // true
		System.out.println(obj.solve("abcde", "eabcd")); // true
		System.out.println(obj.solve("abcde", "abced")); // false
		System.out.println(obj.solve("aaaa", "aaaa"));   // true
		System.out.println(obj.solve("abc", "abc"));     // true
		System.out.println(obj.solve("abc", "abcd"));    // false
	}
}
