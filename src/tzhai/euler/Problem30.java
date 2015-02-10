package tzhai.euler;

import java.util.HashMap;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

/*Problem 30 Digit fifth powers

 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * 1634 = 14 + 64 + 34 + 44
 * 8208 = 84 + 24 + 04 + 84
 * 9474 = 94 + 44 + 74 + 44
 *¡¡As 1 = 14 is not a sum it is not included.
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class Problem30 {
	private static int digitFifthPowers() {
		HashMap<Integer, Integer> fifthPowers = new HashMap<Integer,Integer>();
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			int tempPower = 1;
			for (int j = 0; j < 5; j++) {
				tempPower *= i;
			}
			fifthPowers.put(i, tempPower);
		}
		
		for (int i = 2; i < 1000000; i++) {
			int powerDigit = 0;
			int rest;
			int digit;
			int temp = i;
			do {
				rest = temp/10;
				digit = temp%10;
				powerDigit += fifthPowers.get(digit);
				temp = rest;
			} while (rest != 0 );
			if (i == powerDigit) {
				sum += i;
			}		
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(Problem30.digitFifthPowers());
	}

}
