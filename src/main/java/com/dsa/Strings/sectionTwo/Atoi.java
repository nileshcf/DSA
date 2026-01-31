package com.dsa.Strings.sectionTwo;

class Atoi {
	public int myAtoi(String s) {
		// Initialize index, sign, and result
		int i = 0, sign = 1;
		// Use long to prevent overflow
		long res = 0;

		// Skip leading whitespaces
		while (i < s.length() && s.charAt(i) == ' ') i++;

		// Return 0 if only spaces are found
		if (i == s.length()) return 0;

		// Check for optional '+' or '-' sign
		if (s.charAt(i) == '-') {
			sign = -1;
			i++;
		} else if (s.charAt(i) == '+') {
			i++;
		}

		// Convert characters to integer while valid digits
		while (i < s.length() && Character.isDigit(s.charAt(i))) {
			res = res * 10 + (s.charAt(i) - '0');

			// Clamp to Integer.MAX_VALUE if overflow
			if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;

			// Clamp to Integer.MIN_VALUE if underflow
			if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

			i++;
		}

		// Return final result after applying sign
		return (int)(sign * res);
	}

	public static void main(String[] args) {
		Atoi sol = new Atoi();
		String input = "   -42";
		int result = sol.myAtoi(input);
		System.out.println("Converted integer: " + result);
	}
}
