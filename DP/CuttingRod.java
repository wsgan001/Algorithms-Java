package DP;
//Given a rod of length n inches and an array of prices that contains 
//prices of all pieces of size smaller than n. Determine the maximum value 
//obtainable by cutting up the rod and selling the pieces. 
//For example, if length of the rod is 8 and the values of different pieces 
//are given as following, then the maximum obtainable value is 22 
//(by cutting in two pieces of lengths 2 and 6)
//
//
//length   | 1   2   3   4   5   6   7   8  
//--------------------------------------------
//price    | 1   5   8   9  10  17  17  20
//And if the prices are as following, then the maximum obtainable value is 24 
//(by cutting in eight pieces of length 1)
//
//length   | 1   2   3   4   5   6   7   8  
//--------------------------------------------
//price    | 3   5   8   9  10  17  17  20

public class CuttingRod {

	public static int cutRod(int[] a) {
		if (a == null || a.length == 0)
			return -1;
		int n = a.length;
		int[] f = new int[n + 1];
		f[1] = a[0];
		f[0] = 0;
		for (int i = 2; i <= n; i++) {
			f[i] = a[i - 1];  //not cut
			for (int j = 1; j <= i; j++)
				f[i] = Math.max(f[i], f[i - j] + a[j - 1]);
		}
		return f[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,5,8,9,10,17,17,20};
//		int[] a = {3,5,8,9,10,17,17,20};
		System.out.println(cutRod(a));
	}

}
