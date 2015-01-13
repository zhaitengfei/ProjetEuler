package tzhai.euler;

/**
 * Problem 19 Counting Sundays
 * 
 * 
 * You are given the following information, but you may prefer to do some
 * research for yourself.
 * 
 * 1 Jan 1900 was a Monday. Thirty days has September, April, June and November.
 * All the rest have thirty-one, Saving February alone, Which has twenty-eight,
 * rain or shine. And on leap years, twenty-nine. A leap year occurs on any year
 * evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 * 
 * @author Zhai Tengfei
 *
 */

public class Problem19 {
	private static int countingSundays() {
		int[] countMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int day = 2;
		int sum = 0;
		for (int i = 1901; i <= 2000; i++) {
			if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
				countMonths[1] = 29;
			} else {
				countMonths[1] = 28;
			}
			for (int j = 0; j <= 11; j++) {
				if (day%7 == 0) {
					sum += 1;
				}
				day += countMonths[j]%7;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(Problem19.countingSundays());
	}

}
