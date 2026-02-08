package com.dsa.Strings.sectionTwo;

class Atoi {
	public int myAtoi(String s) {
		// code here

		int i=0;
		int n= s.length();
		while(i<n && s.charAt(i) == ' ')
			i++;

		int sign = 1;

		if(s.charAt(i)=='-')
		{
			sign=-1;
			i++;

		}
		else if(s.charAt(i)=='+')
		{
			i++;
		}

		while(i<n && s.charAt(i)=='0' )
			i++;

		int num = 0;

		while(i<n && Character.isDigit(s.charAt(i)))
		{



			if(sign*num>Integer.MAX_VALUE/10)
			{
				return Integer.MAX_VALUE;
			}
			else if(sign*num<Integer.MIN_VALUE/10)
			{
				return Integer.MIN_VALUE;
			}

			num*=10;
			num+=(s.charAt(i)-'0');

			i++;
		}


		return  sign*num;

	}

	public static void main(String[] args) {
		Atoi sol = new Atoi();
		String input = "   -42";
		int result = sol.myAtoi(input);
		System.out.println("Converted integer: " + result);
	}
}
