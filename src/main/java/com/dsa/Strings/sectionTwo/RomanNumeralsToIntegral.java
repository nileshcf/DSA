package com.dsa.Strings.sectionTwo;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsToIntegral {

	int solve(String romanNum)
	{
		if(romanNum==null || romanNum.isEmpty())
			return 0;

		Map<Character,Integer> romanToNum = new HashMap<>();
		romanToNum.put('C',100);
		romanToNum.put('M',1000);
		romanToNum.put('X',10);
		romanToNum.put('L',50);
		romanToNum.put('I',1);
		romanToNum.put('V',5);
		romanToNum.put('D',500);

		int value=0;
		int currNum;
		int nextNum;
		value+=romanToNum.get(romanNum.charAt(romanNum.length()-1));
		for (int i = romanNum.length()-2; i >= 0; i--) {

			currNum=romanToNum.get(romanNum.charAt(i));
			nextNum=romanToNum.get(romanNum.charAt(i+1));
			if(currNum<nextNum)
			{
				value-=currNum;
			}
			else
			{
				value+=currNum;
			}


		}

		return value;

	}


	public static void main(String[] args) {

		RomanNumeralsToIntegral obj = new RomanNumeralsToIntegral();

		// TEST CASES
		System.out.println("III -> " + obj.solve("III"));       // 3
		System.out.println("IV -> " + obj.solve("IV"));         // 4
		System.out.println("IX -> " + obj.solve("IX"));         // 9
		System.out.println("LVIII -> " + obj.solve("LVIII"));   // 58
		System.out.println("MCMXCIV -> " + obj.solve("MCMXCIV"));// 1994
		System.out.println("MMXXIV -> " + obj.solve("MMXXIV")); // 2024
	}

}
