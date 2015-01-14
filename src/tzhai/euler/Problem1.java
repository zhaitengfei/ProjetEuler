package tzhai.euler;

/**
 * Problem 1 Multiples of 3 and 5
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @author Zhai Tengfei
 *
 */

public class Problem1 {

	public static int cal(int max) {
		int sum = 0;
		for (int i = 0; i < max; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(Problem1.cal(1000));
		return;
	}
	
}
