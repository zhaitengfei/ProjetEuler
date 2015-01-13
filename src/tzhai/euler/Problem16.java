package tzhai.euler;

import java.util.ArrayList;

/**
 * Problem 16 Power digit sum
 * 
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 * 
 * @author Zhai Tengfei
 *
 */

public class Problem16 {
	private static ArrayList<Integer> powerDigitSum(int puissance) {
		ArrayList<Integer> array = new ArrayList<>();
		array.add(2);
		int carry = 0;
		int rest = 0;
		int temp = 0;
		while ((puissance--) != 1) {
			for (int i = array.size() - 1; i >= 0; i--) {
				temp = array.get(i);
				rest = (temp * 2) % 10 + carry;
				array.set(i, rest);
				carry = (temp * 2) / 10;
			}
			if (carry != 0) {
				array.add(0, carry);
				carry = 0;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		ArrayList<Integer> array = Problem16.powerDigitSum(1000);
		int sum = 0;
		for (int i = 0; i < array.size(); i++) {
			sum += array.get(i);
		}
		System.out.println(sum);
	}

}
