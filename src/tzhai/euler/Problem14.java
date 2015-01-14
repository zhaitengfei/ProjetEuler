package tzhai.euler;

import tzhai.euler.lib.MathLib;

/**
 * Problem 14 Longest Collatz sequence
 * 
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n ¡ú n/2 (n is even) n ¡ú 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following
 * sequence:
 * 
 * 13 ¡ú 40 ¡ú 20 ¡ú 10 ¡ú 5 ¡ú 16 ¡ú 8 ¡ú 4 ¡ú 2 ¡ú 1 It can be seen that this sequence
 * (starting at 13 and finishing at 1) contains 10 terms. Although it has not
 * been proved yet (Collatz Problem), it is thought that all starting numbers
 * finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * @author Zhai Tengfei
 *
 */

public class Problem14 {
	private static long longestCollatzSequence() {
		long nb = 0;
		long max = 0;
		for (long i = 1000000; i > 1; i--) {
			long temp = i;
			long count = 1;
			while (temp > 1) {
				if (MathLib.isEven(temp)) {
					temp = temp / 2;
					count++;
				} else {
					temp = 3 * temp + 1;
					count++;
				}
			}
			if (count > max) {
				max = count;
				nb = i;
			}
		}
		return nb;
	}

	public static void main(String[] args) {
		System.out.println(Problem14.longestCollatzSequence());
		
	}
}
