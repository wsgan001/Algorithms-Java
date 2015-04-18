package DP;

import java.util.Arrays;

public class Bag {

	public static int getBag(int m, int[] w, int[] v) {
		int n = w.length;
		if (m == 0 || n == 0) return 0;
		int[][] f = new int[m + 1][n + 1];
		//initialization
		Arrays.fill(f[0], 0);
		for (int i = 0; i <= m; i++) {
			f[i][0] = 0;
		}
			
		//process
		for (int i = 1; i <= m; i++) 
			for (int j = 1; j <= n; j++) {
				f[i][j] = f[i][j - 1];
				if (i >= w[j - 1] && f[i][j] < f[i - w[j - 1]][j] + v[j - 1]) {
					f[i][j] = f[i - w[j - 1]][j - 1] + v[j - 1];
				}
			}
		
		int i = m; 
		int j = n;
		while (j > 0) {
			if (f[i][j] == f[i][j - 1]) {
				j--;
				continue;
			} else {
				System.out.println(j - 1);
				i = i - w[j - 1];
			}
		}
		return f[m][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = {3,4,5,9,4};
		int[] v = {3,4,4,10,4};
		int m = 11;
		System.out.println(getBag(m, w, v));
	}

}
