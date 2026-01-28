package com.dsa.Strings.sectionTwo;

import java.util.*;

public class SortCharByFrequency {

	char[] solve(String word)
	{
		Map<Character,Integer> freq = new HashMap<>();

		for (int i = 0; i < word.length(); i++) {

			freq.put(word.charAt(i),freq.getOrDefault(word.charAt(i),0)+1);
		}

		List<Character> freqChar = new ArrayList<>(freq.keySet());

		freqChar.sort((a,b)-> {
			if (freq.get(a) != freq.get(b)) {
				return freq.get(b) - freq.get(a);
			} else {
				return a - b;
			}
		});


		// convert to array
		char[] result = new char[freqChar.size()];
		for (int i = 0; i < freqChar.size(); i++) {
			result[i] = freqChar.get(i);
		}

		return result;
	}

	public static void main(String[] args) {
		SortCharByFrequency obj = new SortCharByFrequency();
		System.out.println(Arrays.toString(obj.solve("tree"))); // ['e', 'r', 't']
		System.out.println(Arrays.toString(obj.solve("banana"))); // ['a','n','b']
		System.out.println(Arrays.toString(obj.solve("cccaaa"))); // ['a','c'] or ['c','a']? -> c=3,a=3 -> alphabetical => ['a','c']
	}

}
