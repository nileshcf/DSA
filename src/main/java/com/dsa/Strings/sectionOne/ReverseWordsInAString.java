package com.dsa.Strings.sectionOne;

/**
 * Author: Nilesh Verma
 *
 */

public class ReverseWordsInAString {

	String solve(String sentence)
	{
		String[] words = sentence.split(" ");

		StringBuilder reverseSentence = new StringBuilder();

		for(int i=words.length-1;i>=0;i--)
		{
			reverseSentence.append(words[i]);
			if(i!=0)
			{
				reverseSentence.append(" ");
			}
		}

		return reverseSentence.toString();
	}

	String solveWithoutSplit(String sentence)
	{
		StringBuilder word = new StringBuilder();

		int i = sentence.length()-1;


		while(i>=0)
		{
			while(i>=0 && sentence.charAt(i)==' ')
				i--;

			if (i<0)
				break;

			int end = i;

			while (i>=0 && sentence.charAt(i)!=' ')
				i--;

			if(word.length()>0)
				word.append(" ");

			word.append(sentence, i+1, end+1);

		}

		return word.toString();

	}
	public static void main(String[] args) {

		ReverseWordsInAString obj = new ReverseWordsInAString();

		// TEST CASE 1
		String s1 = "hello world this is java";
		System.out.println("Input:    " + s1);
		System.out.println("Split:    " + obj.solve(s1));
		System.out.println("NoSplit:  " + obj.solveWithoutSplit(s1));
		System.out.println();

		// TEST CASE 2 (single word)
		String s2 = "Java";
		System.out.println("Input:    " + s2);
		System.out.println("Split:    " + obj.solve(s2));
		System.out.println("NoSplit:  " + obj.solveWithoutSplit(s2));
		System.out.println();

		// TEST CASE 3 (with multiple spaces)
		String s3 = "  hello   world  ";
		System.out.println("Input:   '" + s3 + "'");
		System.out.println("Split:    " + obj.solve(s3.trim()));
		System.out.println("NoSplit:  " + obj.solveWithoutSplit(s3));
		System.out.println();

		// TEST CASE 4 (empty string)
		String s4 = "";
		System.out.println("Input:   '" + s4 + "'");
		System.out.println("Split:    " + obj.solve(s4));
		System.out.println("NoSplit:  " + obj.solveWithoutSplit(s4));
	}


}
