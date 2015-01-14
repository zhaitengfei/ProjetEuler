package tzhai.euler;

/**
 * Problem 5 : Smallest multiple
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 * 
 * long nb = 1; long i = 0; 
 * while (i != 21) { 
 * 	for (i = 2; i <= 20; i++) { 
 * 		if (nb % i != 0) { nb++; break; } } } 
 * return nb;
 * 
 * @author Zhai Tengfei
 *
 */
public class Problem5 {

	public static long smallestMultiple() {
		long result = 1;
		for (long i = 2; i < 21; i++) {
			result = leastCommonMultiple(result, i);
		}
		return result;
	}
	
	public static long leastCommonMultiple(long a, long b){
		long temp;
		long aa = a;
		long bb = b;
		while(b != 0){
			temp = b;
			b = a % b;
			a = temp;
		}
		return aa * bb / a;
	}

	public static void main(String[] args) {
		System.out.println(Problem5.smallestMultiple());
	}
}
