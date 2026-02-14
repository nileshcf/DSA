package com.dsa.Recursion;

public class Pow {

	int solve(int x,int n)
	{
		if(n==0)
			return 1;

		if(n==1)
			return x;

		if(n%2==0)
			return  solve(x*x,n/2);

		return x*solve(x,n-1);
	}


}
