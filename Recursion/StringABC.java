package Recursion;

import java.util.Arrays;
//Given integer N, find a string contains only character 'A', 'B', or 'C' such that
// - has length of N (N <= 100)
// - every two consecutive substring are not the same
// - has minimum number of character 'C'

public class StringABC {
	
	public static String finalResult = "";
	public static int minC = Integer.MAX_VALUE;

	public static boolean safe(char c, int i, char[] x) {
		if (i < 1) return true;
		x[i] = c;
		for (int l = 1; l <= (i + 1)/2; l++) {
			int end1 = i - l;
			boolean same = true;
			for (int j = 0; j < l; j++)
				if (x[i - j] != x[end1 - j]) {
					same = false;
					break;
				}
			if (same) return false;
					
		}
		return true;
	}
	
	
	public static void run(int i, int n, char[] x,int[] t) {
		for (char c = 'A'; c <= 'C'; c++) 
			if ( safe(c, i, x) && (t[i] + (n - i) / 4 < minC) ) {
				x[i] = c;
				if (c == 'C') 
					if (i == 0) 
						t[i] = 1;
					else t[i] = t[i] + 1;
				if (i == n - 1) {
					if (finalResult.equals("") == true) {
						finalResult = String.valueOf(x);
						minC = Math.min(minC, t[n - 1]);
					}
				} else {
					run(i + 1, n, x, t);
				}
				if (c == 'C') 
					if (i == 0) 
						t[i] = 1;
					else t[i] = t[i] + 1;
			}
	}
	
	public static String stringABC(int n) {
		String re = "";
		if (n == 0) return null;
		char[] x = new char[n];
		int[] t = new int[n]; //count the number of C
		Arrays.fill(t, 0);
		run(0, n , x, t);
		return finalResult;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		String s = stringABC(100);
		System.out.println(s);
		long endTime = System.currentTimeMillis();
		long elapseTime = endTime - startTime;
		System.out.println("Elapsed time = " + elapseTime/1000.0 + "(s)");
	}

}
