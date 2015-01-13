package tzhai.euler;

import java.util.HashMap;

/**
 * Problem 21 Amicable numbers
 * 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n). If d(a) = b and d(b) = a, where a ¡Ù b, then a
 * and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * @author Zhai Tengfei
 *
 */

public class Problem21 {
	private static int amicableNumbers(int number) {
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		hashmap.put(1, 0);
		int sum = 0;
		int tempSum = 0;

		for (int i = 2; i <= number; i++) {
			if (!hashmap.containsKey(i)) {
				tempSum = 0;
				for (int j = 1; j <= i/2; j++) {
					if (i % j == 0) {
						tempSum += j;
					}
				}
				hashmap.put(i, tempSum);
			} else {
				tempSum = hashmap.get(i);
			}

			// a != b
			if (hashmap.containsKey(tempSum) && hashmap.get(tempSum) == i && i!=tempSum) {
					sum = sum + i + tempSum;
			}
	
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(Problem21.amicableNumbers(10000));
	}

}
