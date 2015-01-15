package tzhai.euler.lib;

public class MathLib {

	public static boolean isPrime(long a) {
		if (a <= 1)
			return false;
		if (a == 2)
			return true;
		else {
			for (long i = 2; i <= Math.sqrt(a); i++) {
				if (a % i == 0)
					return false;
			}
			return true;
		}
	}

	public static boolean isSquare(long a) {
		for (int i = 1; a > 0; i += 2) {
			a -= i;
		}
		return a == 0;
	}

	public static boolean isEven(long a) {
		if (a % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean is2Power(long a) {
		if (a < 2) {
			return false;
		}
		if ((a & a - 1) == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static int nb2Power(long a) {
		if (is2Power(a)) {
			return (int) (Math.log(a) / Math.log(2));
		} else {
			return -1;
		}
	}

}
