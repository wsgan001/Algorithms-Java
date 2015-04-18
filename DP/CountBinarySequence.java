package DP;
//Given a positive integer N, count all possible distinct binary strings of length N 
//such that there are no consecutive 1’s.
//
//Examples:
//
//Input:  N = 2
//Output: 3
//// The 3 strings are 00, 01, 10
//
//Input: N = 3
//Output: 5
//// The 5 strings are 000, 001, 010, 100, 101
public class CountBinarySequence {

	public static int countBinary(int n) {
		if (n < 0) return -1;
		int[][] f = new int[n][2];
		f[0][0] = 1;
		f[0][1] = 1;
		for (int i = 1; i < n; i++) {
			f[i][0] = f[i - 1][0] + f[i - 1][1];
			f[i][1] = f[i - 1][0];
		}
		return f[n - 1][0] + f[n - 1][1];	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countBinary(2));
	}

}
