package tzhai.euler;

import java.util.ArrayList;
/**
 * Problem 26 Reciprocal cycles
 * 
 * A unit fraction contains 1 in the numerator. The decimal representation of
 * the unit fractions with denominators 2 to 10 are given:
 * 
 * 1/2 = 0.5 1/3 = 0.(3) 1/4 = 0.25 1/5 = 0.2 1/6 = 0.1(6) 1/7 = 0.(142857) 1/8
 * = 0.125 1/9 = 0.(1) 1/10 = 0.1 Where 0.1(6) means 0.166666..., and has a
 * 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring
 * cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 * 
 * @author Zhai Tengfei
 *
 */

public class Problem26 {
	private static int reciprocalCycles(int limit) {
		ArrayList<Integer> carryRecord = new ArrayList<Integer>();
		int numberDigit = 0;
		int longestRecurringCycle = 0;
		int result = 0;
		for (int i = 2; i < limit; i++) {
			int carry = 1;
			int rest = 0;
			carryRecord.clear();
			while (carry != 0) {
				carryRecord.add(carry);
				rest = carry * 10 / i;
				carry = carry * 10 - rest * i;
				if (carryRecord.contains(carry)) {
					numberDigit = carryRecord.size()
							- carryRecord.indexOf(carry);
					if (numberDigit > longestRecurringCycle) {
						longestRecurringCycle = numberDigit;
						result = i;
					}
					break;
				}
			}
		}
		return result;

	}

	public static void main(String[] args) {
		System.out.println(Problem26.reciprocalCycles(1000));
	}

}
