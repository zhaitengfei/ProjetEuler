package tzhai.euler;

/**If the numbers 1 to 5 are written out in words: one, two, three, four, five, 
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, 
 * how many letters would be used?
 * NOTE: Do not count spaces or hyphens. 
 * For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
 * The use of "and" when writing out numbers is in compliance with British usage.
 * 
 */

import java.util.HashMap;

public class Problem17 {
	private static HashMap<Integer, Integer> hashMap;

	private static void ini() {
		hashMap = Problem17.createHashMap();
	}

	private static HashMap<Integer, Integer> createHashMap() {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int value;
		map.put(1, 3);
		map.put(2, 3);
		map.put(3, 5);
		map.put(4, 4);
		map.put(5, 4);
		map.put(6, 3);
		map.put(7, 5);
		map.put(8, 5);
		map.put(9, 4);
		map.put(10, 3);
		map.put(11, 6);
		map.put(12, 6);
		map.put(13, 8);
		map.put(14, 8);
		map.put(15, 7);
		map.put(16, 7);
		map.put(17, 9);
		map.put(18, 8);
		map.put(19, 8);
		map.put(20, 6);
		map.put(30, 6);
		map.put(40, 5);
		map.put(50, 5);
		map.put(60, 5);
		map.put(70, 7);
		map.put(80, 6);
		map.put(90, 6);
		map.put(-1, 7); // hundred
		map.put(100, 10); // one hundred
		map.put(1000, 11); // one thousand

		for (int i = 21; i < 100; i++) {
			value = 0;
			if (i % 10 != 0) {
				value = value + map.get(i % 10) + map.get(i / 10 * 10);
				map.put(i, value);
			}
		}

		for (int i = 101; i < 1000; i++) {
			value = 0;
			if (i % 100 != 0) {
				value = value + map.get(i % 100) + map.get(i / 100)
						+ map.get(-1) + 3;
				map.put(i, value);
			} else if (i % 100 == 0) {
				value = value + map.get(i / 100) + map.get(-1); // map.get(-1)
																// is hundred
				map.put(i, value);
			}
		}

		return map;
	}

	private static int numberLetterCounts(int number) {
		int letterCounts = 0;
		if (number > 0 && number <= 1000) {
			letterCounts = hashMap.get(number);
		}
		return letterCounts;

	}

	public static void main(String[] args) {
		Problem17.ini();
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			sum += Problem17.numberLetterCounts(i);
		}
		System.out.println(sum);
	}
}
