package tzhai.euler;

/**
 * Problem 4 Largest palindrome product
 * 
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 ¡Á 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author Zhai Tengfei
 *
 */
public class Problem4 {

	public static boolean isPalindromic(int n) {
		String str = Integer.toString(n);
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) != str.charAt(len - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static int maxPalindrome() {
		int product = 0;
		int max = 0;
		for (int i = 999; i > 99; i--) {
			for (int j = 999; j > 99; j--) {
				product = i * j;
				if (Problem4.isPalindromic(product) && product > max) {
					max = product;
				}
			}
		}
		return max;
	}

	public static void main(String args[]) {
		System.out.println(Problem4.maxPalindrome());
	}

}
