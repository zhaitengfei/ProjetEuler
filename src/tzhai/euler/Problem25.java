package tzhai.euler;

import java.util.ArrayList;

/**Problem 24 Lexicographic permutations
 * 
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order. The
 * lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012 021 102 120 201 210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 * 
 * @author Zhai Tengfei
 *
 */

public class Problem25 {
	private static ArrayList<Integer> lexicographicPermutations(int n) {
		int order = n;
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[] factorial = new int[9];
		for (int i = 9; i >= 1; i--) {
			int temp = 1;
			for (int j = i; j >= 1; j--) {
				temp *= j;
			}
			factorial[9-i] = temp;
		}
		
		ArrayList<Integer> digits = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			digits.add(i);
		}
		
		while (order != 1) {
			for (int i = 0; i < 9; i++) {
				for (int j = 1; j < 11-i; j++) {
					if ((factorial[i]*j) >= order) {
    						result.add(digits.remove(j-1));
						order -= factorial[i]*(j-1);
						break;
					}
				}
			}
		}
		result.add(digits.get(0));	
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Problem25.lexicographicPermutations(1000000));
	}

}
