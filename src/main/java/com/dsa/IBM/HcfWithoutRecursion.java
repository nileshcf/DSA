package com.dsa.IBM;

public class HcfWithoutRecursion {

	int solve(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);

		if (a == 0) return b;
		if (b == 0) return a;

		while (a != 0 && b != 0) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a == 0 ? b : a;
	}

	// HCF(a, b) = HCF(b, a % b)
	int fasterSolve(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);

		if (a == 0) return b;
		if (b == 0) return a;

		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public static void main(String[] args) {
		HcfWithoutRecursion hcf = new HcfWithoutRecursion();

		System.out.println("Subtraction method:");
		System.out.println(hcf.solve(12, 18));   // 6
		System.out.println(hcf.solve(10, 5));    // 5
		System.out.println(hcf.solve(0, 15));    // 15
		System.out.println(hcf.solve(-12, 18));  // 6

		System.out.println("\nModulo (fast) method:");
		System.out.println(hcf.fasterSolve(12, 18));  // 6
		System.out.println(hcf.fasterSolve(10, 5));   // 5
		System.out.println(hcf.fasterSolve(0, 15));   // 15
		System.out.println(hcf.fasterSolve(-12, 18)); // 6
	}
}

