package RECAP;

import java.util.ArrayList;
import java.util.Arrays;

public class Queen {
	
	public static void run(int i, int[] x, boolean[] row, boolean[] d1, boolean[] d2, ArrayList<int[]> res) {
		int n = x.length;
		for (int j = 0; j < n; j++) 
			if (row[j] && d1[i + j] && d2[i - j + n]) {
				x[i] = j;
				row[j] = false;
				d1[i + j] = false;
				d2[i - j + n] = false;
				if (i == n - 1) {
					res.add(x.clone());
				} else {
					run(i + 1, x, row, d1, d2, res);
				}
				row[j] = true;
				d1[i + j] = true;
				d2[i - j + n] = true;
			}
	}

	public static ArrayList<int[]> queen(int n) {
		ArrayList<int[]> res = new ArrayList<int[]>();
		int[] x = new int[n];
		boolean[] row = new boolean[n];
		boolean[] d1 = new boolean[2*n];
		boolean[] d2 = new boolean[2*n];
		Arrays.fill(x, 0);
		Arrays.fill(row, true);
		Arrays.fill(d1, true);
		Arrays.fill(d2, true);
		run(0, x, row, d1, d2, res);
		return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<int[]> res = queen(8);
		for (int[] x : res) {
			for (int i : x)
				System.out.print(i + " ");
			System.out.println();
		}
		System.out.println(res.size());
	}

}
