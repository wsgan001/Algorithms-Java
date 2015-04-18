package DP;

public class PhanTichSo {
	//how many ways to express integer n as sum of smaller integer
	//n = 5 -> 7 ways
	//1 1 1 1 1
	//1 1 1 2
	//1 1 3
	//1 2 2
	//1 4
	//2 3
	//5
	public static int analysis(int n) {
		int[][] f = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
				f[i][j] = 0;
		for (int j = 0; j <= n; j++)
			f[0][j] = 1;
		
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++) {
				if (i < j)
					f[i][j] = f[i][j - 1];
				else {
					for (int k = 0; k*j <= i; k++)
						f[i][j] += f[i - k*j][j - 1];
				}
			}
				
		return f[n][n];
	}
	//Given a value N, if we want to make change for N cents, 
	//and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
	//how many ways can we make the change? The order of coins doesn’t matter.
	//
	//For example, for N = 4 and S = {1,2,3}, there are four solutions: 
	//{1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and 
	//S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, 
	//{2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
	public static int coinChange(int[] s, int m) {
		int n = s.length;
		int[][] f = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			f[i][0] = 0;
		for (int j = 0; j <= n; j++)
			f[0][j] = 1;
		f[0][0] = 1;
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				f[i][j] = f[i][j - 1];
				if (i >= s[j-1]) 
					for (int k = 1; k*s[j-1] <= i; k++)
						f[i][j] += f[i - k*s[j-1]][j - 1];
			}
		return f[m][n];
	}
	
	public static int coinChangeRecursive(int[] s, int n, int m) {
		if (m == 0)
			return 1;
		if (m < 0)
			return 0;
		if (n <= 0 && m > 0)
			return 0;
		return coinChangeRecursive(s, n - 1, m) + coinChangeRecursive(s, n, m - s[n - 1]);
	}
	
//co bao nhieu so nguyen duong co <= n chu so ma tong cac chu so = k
	
	public static int getCountDigits(int n, int k) {
		if (n == 0) return 0;
		int[][] f = new int[n + 1][k + 1];
		for (int i = 0; i < n; i++)
			f[i][k] = 0;
		for (int j = 0; j < k; j++)
			f[0][j] = 0;
		f[0][0] = 1;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= k; j++) {
				for (int d = 0; d <= 9; d++)
					if (j >= d)
						f[i][j] += f[i - 1][j - d];
			}
				
		return f[n][k];
	}
	
//co n goi keo (n <= 200), moi goi chua ko qua 200 cai keo va 1 so M < 40000.
//tim cach lay ra 1 so it nhat goi keo de dc tong so keo la M. hoac thong bao ko the
	
	
	public static int divideCandy(int[] a, int m) {
		int n = a.length;
		int[] f = new int[m + 1];
		f[0] = 0;
		int oo = 10000000;
		for (int i = 1; i <= m; i++) {
			f[i] = oo;
			for (int j = 1; j <= n; j++) 
				if (i >= a[j-1] && f[i - a[j-1]] < j) {
					f[i] = j;
					break;
				}
		}
		int i = m;
		while (i > 0) {
			System.out.println(f[i]);
			i = i - a[f[i] - 1];
		}
		return f[m];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(analysis(5));
//		System.out.println(getCountDigits(3, 5));
//		int[] a = {1,3,2,4};
		int[] a = {3, 34, 4, 12, 5, 2};
		System.out.println(divideCandy(a, 9));
//		int[] a = {2,1,3};
//		System.out.println(coinChange(a, 243));
//		System.out.println(coinChangeRecursive(a, 3, 243));
	}

}
