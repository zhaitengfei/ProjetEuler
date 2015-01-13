package tzhai.euler;

/**
 * * Problem 9 Special Pythagorean triplet
 * 
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which,
 * 
 * a2 + b2 = c2 For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find
 * the product abc
 * 
 * @author Zhai Tengfei
 *
 */

public class Problem9 {

	private static long specialPythagoreanTriplet() {
		long res = 0;
		for (long c = 1; c < 1001; c++) {
			for (long b = 1; b < c; b++) {
				long a = 1000 - b - c;
				if ((a >= b) || (a <= 0)) {
					continue;
				}
				if (a * a + b * b == c * c) {
					res = a * b * c;
					return res;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(Problem9.specialPythagoreanTriplet());
	}

}
