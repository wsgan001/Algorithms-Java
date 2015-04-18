package DP;

import java.util.Arrays;
//Tim day con dai nhat co tong chia het cho k O(n^2)

public class DayConTongChiaHetK {

	public static int sub(int x, int y, int k) {
		//calculate (x - y) mod k
		int temp = (x - y) % k;
		if (temp >= 0) 
			return temp;
		else 
			return temp + k;
	}
	
	public static int subSeq(int[] a, int k) {
		if (a == null || a.length == 0) return 0;
		if (k <= 0) return -1;
		int n = a.length;
		int[] c = new int[k];
		Arrays.fill(c, 0);;
		for (int i = 0; i < n; i++)
			c[a[i] % k]++;
		
		int[][] f = new int[k][k];
		f[0][0] = c[0];
		int[][] trace = new int[k][k];
		for (int i = 0; i < k; i++)
			for (int j = 0; j < k; j++)
				trace[i][j] = -1;
		trace[0][0] = c[0];
		
		for (int i = 1; i < k; i++)
			for (int t = 0; t < k; t++)
				for (int j = 0; j <= c[i]; j++)
					if (trace[i-1][sub(t,i*j,k)] != -1 && f[i][t] < f[i-1][sub(t,i*j,k)] + j) {
						f[i][t] = f[i-1][sub(t,i*j,k)] + j;
						trace[i][t] = j;
					}
		return f[k-1][0];				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = {1,6,11,5,10,15,20,2,4,9};
		int[] a = {1,2,3};
		System.out.println(subSeq(a, 5));
	}

}
