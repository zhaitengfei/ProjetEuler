package tzhai.euler;

/**Problem 20 Factorial digit sum

 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 */

import java.util.ArrayList;

public class Problem20 {
	private static ArrayList<Integer> factorialDigitSum(int factorial) {
		ArrayList<Integer> array = new ArrayList<>();
		array.add(1);
		int factor = 1;
		int carry = 0;
		int rest = 0;
		int temp = 0;
		while (factor <= factorial) {
			for (int i = array.size() - 1; i >= 0; i--) {
				temp = array.get(i) * factor + carry;
				rest = temp % 10;
				carry = temp / 10;
				array.set(i, rest);
			}
			while (carry != 0) {
				array.add(0, carry % 10);
				carry = carry / 10;
			}
			factor++;
		}
		return array;
	}

	public static void main(String[] args) {
			ArrayList<Integer> array = Problem20.factorialDigitSum(100);
			int sum = 0;
			for (int i = 0; i < array.size(); i++) {
				sum += array.get(i);
			}
			System.out.println("100! = " + array);
			System.out.println(sum);
		}

}
