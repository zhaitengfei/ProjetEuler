package tzhai.euler;

/**
 * Problem 15 Lattice paths
 * 
 * Starting in the top left corner of a 2¡Á2 grid, and only being able to move to
 * the right and down, there are exactly 6 routes to the bottom right corner.
 * 
 * 
 * How many such routes are there through a 20¡Á20 grid?
 * 
 * @author Zhai Tengfei
 *
 */
public class Problem15 {
	private static long latticePaths(int size) {
		long a[][] = new long [size][size];
		
		for (int i = size - 1; i >= 0; i--) {
			for (int j = size -1; j >= 0; j--) {
				if (i == size -1) {
					a[i][j] = 1;
				} else if (j == size -1) {
					a[i][j] = 1;
				} else{
					a[i][j] = a[i+1][j] + a[i][j+1];
				}
			}
		}
		return a[0][0];
	}
	
	private static long latticePathsRecursion(int i, int j) {
		return (i == 0 || j == 0) ? 1 : latticePathsRecursion(i, j-1) + latticePathsRecursion(i-1, j);
	}
	
	public static void main(String[] args) {
		System.out.println(Problem15.latticePaths(21));
		System.out.println(Problem15.latticePathsRecursion(20, 20));
	}

}
