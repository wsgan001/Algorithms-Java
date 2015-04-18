package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Queen {

	public static void run(int j, int n, int[] x, boolean[] r, boolean[] c1, boolean[] c2, ArrayList<int[]> re) {
		for (int i = 0; i < n; i++) 
			if (r[i] && c1[i + j] && c2[i - j + n]) {
				x[j] = i;
				r[i] = false;
				c1[i + j] = false;
				c2[i - j + n] = false;
				if (j == n - 1) {
					//update result
					int[] a = new int[n];
					System.arraycopy(x, 0, a, 0, n);
					re.add(a);
				} else {
					run(j + 1, n, x, r, c1, c2, re);
				}
				r[i] = true;
				c1[i + j] = true;
				c2[i - j + n] = true;
			}
				
	}
	
	public static ArrayList<int[]> queen(int n) {
		ArrayList<int[]> re = new ArrayList<int[]>();
		if (n == 0) return re;
		int[] x = new int[n]; //i-position of queen in column i-th
		boolean[] r = new boolean[n];
		boolean[] c1 = new boolean[2*n - 1];
		boolean[] c2 = new boolean[3*n - 1];
		Arrays.fill(x, 0);
		Arrays.fill(r, true);
		Arrays.fill(c1, true);
		Arrays.fill(c2, true);
		run(0, n, x, r, c1, c2, re); //search from column 0
		return re;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<int[]> re = queen(8);
		if (re.size() == 0) {
			System.out.println("NO SOLUTION");
			return;
		}
		for (int[] x : re) {
			for (int j = 0; j < x.length; j++)
				System.out.print(x[j] + " ");
			System.out.println();
		}
		System.out.println(re.size());
	}

}
