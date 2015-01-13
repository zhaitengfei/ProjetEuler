package tzhai.euler;

import java.util.HashMap;

import tzhai.euler.lib.FileLib;

/**
 * Problem 22 Names scores
 * 
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
 * containing over five-thousand first names, begin by sorting it into
 * alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name
 * score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 ¡Á 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 * @author Zhai Tengfei
 *
 */
public class Problem22 {
	private static int namesScores() {
		HashMap<Character, Integer> worth = new HashMap<Character, Integer>();
		int sum = 0;
		String string = null;
		string = FileLib
				.readFileByChar2("E:\\Code\\Euler\\src\\tzhai\\euler\\inputProblem22.txt");
		String[] str = string.split("\\,");
		for (int i = 0; i < str.length; i++) {
			str[i] = str[i].substring(str[i].indexOf("\"") + 1,
					str[i].lastIndexOf("\""));
		}

		for (int i = 0; i < 27; i++) {
			worth.put((char)(i + 65), i+1);
		}
		
		// choose the smallest
		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1 ; j < str.length; j++) {
				if (str[i].compareTo(str[j]) > 0) {
					String temp = str[i];
					str[i] = str[j];
					str[j] = temp;
				}
			}
		}
		for (int i = 0; i < str.length; i++) {
			int position = i+1;
			int sumTemp = 0;
			for (int k = 0; k < str[i].length(); k++) {
				sumTemp += worth.get(str[i].charAt(k));
			}
			sum += sumTemp*position;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(Problem22.namesScores());
	}

}
