package tzhai.euler;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Problem 29 Distinct powers
 * 
 * Consider all integer combinations of ab for 2 �� a �� 5 and 2 �� b �� 5: 22=4,
 * 23=8, 24=16, 25=32 32=9, 33=27, 34=81, 35=243 42=16, 43=64, 44=256, 45=1024
 * 52=25, 53=125, 54=625, 55=3125 If they are then placed in numerical order,
 * with any repeats removed, we get the following sequence of 15 distinct terms:
 * 
 * 4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125
 * 
 * How many distinct terms are in the sequence generated by a^b for 2 �� a �� 100
 * and 2 �� b �� 100?
 * 
 * @author Zhai Tengfei
 *
 */

public class Problem29 {
	private static int dintinctPowers() {
		HashSet<String> powers = new HashSet<String>();
		ArrayList<Integer> power = new ArrayList<Integer>();
		ArrayList<Integer> tempPower = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int rest;
		int carry;
		for (int a = 2; a < 101; a++) {
			power.clear();
			if (a / 10 == 0) {
				power.add(a);
			} else if (a / 10 != 0 && a / 100 == 0) {
				rest = a % 10;
				carry = a / 10;
				power.add(carry);
				power.add(rest);
			} else if (a == 100) {
				power.add(1);
				power.add(0);
				power.add(0);
			}
			for (int b = 2; b < 101; b++) {
				int puissance = b;
				tempPower = power;
				while ((puissance--) != 1) {
					int index = tempPower.size()-1;
					carry = 0;
					rest = 0;
					while (carry!=0 || index >= 0) {
						int temp;
						if (index>=0) {
							temp = tempPower.get(index) * a + carry;
						} else{
							temp = carry;}
						rest = temp%10;
						carry = temp/10;
						result.add(0, rest);
						index--;
					}
					tempPower = (ArrayList<Integer>)result.clone();
					result.clear();
				}
				String temp = "";
				for (int i = 0; i < tempPower.size(); i++) {
					 temp += tempPower.get(i);
				}
				if (!powers.contains(temp)) {
					powers.add(temp);
				}
			}
		}
		return powers.size();
	}

	public static void main(String[] args) {
		System.out.println(Problem29.dintinctPowers());
	}
}