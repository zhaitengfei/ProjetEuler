package tzhai.euler;

import java.util.concurrent.CountDownLatch;

/**
 * Problem 31 Coin sums
 * 
 * In England the currency is made up of pound, £, and pence, p, and there are
 * eight coins in general circulation:
 * 
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p). It is possible to make £2
 * in the following way:
 * 
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p How many different ways can £2 be
 * made using any number of coins?
 * 
 * @author Zhai Tengfei
 *
 */

public class Problem31 {
	private static int count;
	private static int[] coins = { 200, 100, 50, 20, 10, 5, 2, 1 };

	private static void coinSums(int remain, int maxCoinIndex) {
		if (remain == 0) {
			count++;
			return;
		}
		if (maxCoinIndex >= coins.length) {
			return;
		}
		
		int maxCoin = coins[maxCoinIndex];
		int maxCount = remain / maxCoin;
		for (int i = 0; i <= maxCount; i++) {
			coinSums(remain - i*maxCoin, maxCoinIndex+1);
		}
	}

	public static void main(String[] args) {
		Problem31.coinSums(200, 0);
		System.out.println(count);
	}

}
