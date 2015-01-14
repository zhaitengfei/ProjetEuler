package tzhai.euler;


import tzhai.euler.lib.MathLib;

/**
 * Problem 7 10001st prime
 * 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 * 
 * @author Zhai Tengfei
 *
 */

public class Problem7 {
	private static int findNthPrime(int n) {
		int count = 0;
		int i = 0;
		while (count != n) {
			if (MathLib.isPrime(++i)) {
				count++;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		System.out.println(Problem7.findNthPrime(10001));
	}

}
