package tzhai.euler;

import java.util.ArrayList;

/**
 * 
 * @author Zhai Tengfei
 *
 */

public class Problem25 {
	private static int digitFinonacciNumber(int numbersDigits) {
		ArrayList<Integer> small = new ArrayList<Integer>();
		ArrayList<Integer> grand = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		small.add(1);
		grand.add(1);
		int digits = 0;
		int term = 2;
		int carry = 0;
		int rest = 0;
		while (digits < numbersDigits) {
			int smallLength = small.size();
			int grandLength = grand.size();
			int i = 0;
			while ((carry != 0) || (i < grandLength)) {
				if (i < smallLength) {
					rest = (small.get(i)+grand.get(i)+carry)%10;
					carry = (small.get(i)+grand.get(i)+carry)/10;
				} else if (i >= smallLength && i < grandLength) {
					rest = (grand.get(i)+carry)%10;
					carry = (grand.get(i)+carry)/10;
				} else {
					rest = carry%10;
					carry = carry/10;
				}
				result.add(rest);
				i++;
			}
			term++;
			digits = result.size();
			small = grand;
			grand = (ArrayList<Integer>)result.clone();
			result.clear();
		}
		return term;
	}
	
	public static void main(String[] args) {
		System.out.println(Problem25.digitFinonacciNumber(1000));
	}

}
