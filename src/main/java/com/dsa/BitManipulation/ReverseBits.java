package com.dsa.BitManipulation;

public class ReverseBits {

	int solve(int n)
	{
		StringBuilder sb = new StringBuilder();

		while(n>0)
		{
			sb.append(n%2);
			n/=2;
		}

		System.out.println(sb);

		int i=1,c=0;
		int num=0;
		while(c<sb.length())
		{
			num=(sb.charAt(c)-'0')*i;
			i*=2;
			c++;
		}

		System.out.println("Reverse is "+num);
		return num;
	}

	public static void main(String[] args) {
		ReverseBits r=new ReverseBits();
		r.solve(4);
	}
}
