package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {

	
	public static void run(int i, int n, int[] x, boolean[] valid, ArrayList<int[]> re) {
		for (int j = 1; j <= n; j++)
			if (valid[j]) {
				x[i] = j;
				valid[j] = false;
				if (i == n - 1) {
					int[] a = new int[n];
					System.arraycopy(x, 0, a, 0, n);
					re.add(a);
				} else {
					run(i + 1, n, x, valid, re);
				}
				valid[j] = true;
			}
	}
	
	public static ArrayList<int[]> permutation(int n) {
		ArrayList<int[]> re = new ArrayList<int[]>();
		int[] x = new int[n];
		boolean[] valid = new boolean[n + 1];
		Arrays.fill(valid, true);
		run(0, n, x, valid, re);
		return re;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<int[]> r = permutation(7);
		for (int[] x : r) {
			for (int i = 0; i < x.length; i++) 
				System.out.print(x[i] + " ");
			System.out.println();
		}
	}

}
