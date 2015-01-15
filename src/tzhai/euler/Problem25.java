package tzhai.euler;

import java.util.ArrayList;

/**
 * Problem 25 1000-digit Fibonacci number
 * 
 * The Fibonacci sequence is defined by the recurrence relation:
 * 
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1. Hence the first 12 terms will be:
 * 
 * F1 = 1 F2 = 1 F3 = 2 F4 = 3 F5 = 5 F6 = 8 F7 = 13 F8 = 21 F9 = 34 F10 = 55
 * F11 = 89 F12 = 144 The 12th term, F12, is the first term to contain three
 * digits.
 * 
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 * 
 * @author Zhai Tengfei
 *
 */

public class Problem25 {
	private static int digitFinonacciNumber(int numbersDigits) {
		ArrayList<Integer> small = new ArrayList<Integer>();
		ArrayList<Integer> grand = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		small.add(1);
		grand.add(1);
		int digits = 0;
		int term = 2;
		int carry = 0;
		int rest = 0;
		while (digits < numbersDigits) {
			int smallLength = small.size();
			int grandLength = grand.size();
			int i = 0;
			while ((carry != 0) || (i < grandLength)) {
				if (i < smallLength) {
					rest = (small.get(i) + grand.get(i) + carry) % 10;
					carry = (small.get(i) + grand.get(i) + carry) / 10;
				} else if (i >= smallLength && i < grandLength) {
					rest = (grand.get(i) + carry) % 10;
					carry = (grand.get(i) + carry) / 10;
				} else {
					rest = carry % 10;
					carry = carry / 10;
				}
				result.add(rest);
				i++;
			}
			term++;
			digits = result.size();
			small = grand;
			grand = (ArrayList<Integer>) result.clone();
			result.clear();
		}
		return term;
	}

	public static void main(String[] args) {
		System.out.println(Problem25.digitFinonacciNumber(1000));
	}

}
