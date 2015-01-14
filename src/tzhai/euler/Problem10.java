package tzhai.euler;

import tzhai.euler.lib.MathLib;

/**
 * Problem 10 Summation of primes
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 
 * @author Zhai Tengfei
 *
 */
public class Problem10 {

	private static long summationPrimes(long max) {
		long sum = 0;
		for (int i = 2; i < max; i++) {
			if (MathLib.isPrime(i)) {
				sum += i;
			}
		}
		return sum;
	}

	private static long summationPrimeOptimiser(int max) {
		long sum = 0;
		boolean a[]= new boolean[max];
		for (int i = 0; i < max; i++) {
			a[i] = true;
		}
		for (int i = 2; i < max/2; i++) {
			for (int j = 2 * i; j < max; j += i) {
				a[i*j] = false;
			}
		}
		
		a[1] = false;
		for (int i = 0; i < max; i++) {
			if (a[i] == true) {
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(Problem10.summationPrimeOptimiser((int)2E6));
	}
}
