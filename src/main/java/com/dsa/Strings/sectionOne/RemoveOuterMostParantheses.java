package com.dsa.Strings.sectionOne;

public class RemoveOuterMostParantheses {

	String solve(String brackets)
	{
		StringBuilder ans = new StringBuilder();
		int level =0;


		for(int i =0 ;i< brackets.length();i++)
		{
			if(brackets.charAt(i)=='(')
			{
				if(level>0)
				{
					ans.append('(');

				}
				level++;
			}else{
				level--;
				if(level>0)
					ans.append(')');


			}
		}

		return ans.toString();
	}

	public static void main(String[] args) {
		RemoveOuterMostParantheses obj = new RemoveOuterMostParantheses();

		System.out.println(obj.solve("(()())(())"));       // Expected: "()()()"
		System.out.println(obj.solve("(()())(())(()(()))"));// Expected: "()()()(())"
		System.out.println(obj.solve("()()"));              // Expected: ""
		System.out.println(obj.solve("((()))"));            // Expected: "(())"
	}

}
