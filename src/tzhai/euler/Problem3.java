package tzhai.euler;

import tzhai.euler.lib.MathLib;

/**
 * Problem 3 Largest prime factor
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author Zhai Tengfei
 * 
 *         def main(): 
 *         
 *         i = 600851475143 
 *         j = i/2 
 *         k = 2
 * 
 *         while k < j: 
 *         		l = i / k 
 *         		if(i % l == 0 and is_prime(l)): 
 *         			print l 
 *         			break
 *         k += 1
 *
 */
public class Problem3 {

	public static long maxPrimeFactor(long a) {
		long max = 0;
		for (long i = 2; i <= (long) Math.sqrt(a); i++) {
			if (a % i == 0) {
				long j = a / i;
				if ((MathLib.isPrime(j) == true) && (j > max)) {
					max = j;
				} else if ((MathLib.isPrime(i) == true) && (i > max)) {
					max = i;
				}
			}
		}
		return max;
	}

	public static void main(String args[]) {
		System.out.println(Problem3.maxPrimeFactor(600851475143L));
	}
}
