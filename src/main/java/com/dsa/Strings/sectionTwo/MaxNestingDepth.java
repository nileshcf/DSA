package com.dsa.Strings.sectionTwo;

public class MaxNestingDepth {

	int solve(String equation)
	{
		int level=0,maxLevel=0;
		for (int i = 0; i <equation.length(); i++) {

			if(equation.charAt(i)=='(')
			{
				level++;
				maxLevel=Math.max(maxLevel,level);
			} else if (equation.charAt(i)==')'){
				level--;

			}
		}

		return maxLevel;
	}

	public static void main(String[] args) {

		MaxNestingDepth obj = new MaxNestingDepth();

		// TEST CASE 1 (Given example)
		String s1 = "(1+(2*3)+((8)/4))+1";
		System.out.println("Input: " + s1);
		System.out.println("Output: " + obj.solve(s1)); // Expected: 3
		System.out.println();

		// TEST CASE 2 (Given example)
		String s2 = "(1)+((2))+(((3)))";
		System.out.println("Input: " + s2);
		System.out.println("Output: " + obj.solve(s2)); // Expected: 3
		System.out.println();

		// TEST CASE 3 (Simple)
		String s3 = "()";
		System.out.println("Input: " + s3);
		System.out.println("Output: " + obj.solve(s3)); // Expected: 1
		System.out.println();

		// TEST CASE 4 (No parentheses)
		String s4 = "123+456";
		System.out.println("Input: " + s4);
		System.out.println("Output: " + obj.solve(s4)); // Expected: 0
		System.out.println();

		// TEST CASE 5 (Nested deeply)
		String s5 = "(((((x)))))";
		System.out.println("Input: " + s5);
		System.out.println("Output: " + obj.solve(s5)); // Expected: 5
		System.out.println();

		// TEST CASE 6 (Mix)
		String s6 = "(a+(b/(c-d)))+(e)";
		System.out.println("Input: " + s6);
		System.out.println("Output: " + obj.solve(s6)); // Expected: 3
	}
}
