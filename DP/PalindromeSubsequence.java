package DP;
//Given a sequence, find the length of the longest palindromic subsequence in it.
//For example, if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” 
//is the longest palindromic subseuqnce in it.
public class PalindromeSubsequence {
	
	public static String getLPS(String s) {
		if (s.isEmpty() || s.length() <= 1)
			return s;
		
		char[] a = s.toCharArray();
		int n = a.length;
		int[][] f = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
			f[i][i] = 1;
		
		for (int len = 2; len <= n; len++)
			for (int i = 1; i <= n - len + 1; i++) {
				int j = i + len - 1;
//				System.out.println(i + " " + j);
				if (a[i - 1] == a[j - 1])
					f[i][j] = f[i + 1][j - 1] + 2;
				else
					f[i][j] = Math.max(f[i][j - 1], f[i + 1][j]);
			}
		System.out.println(f[1][n]);
		return "";
	}
	
	public static String getLPSbyLCS(String s) {
		String sr = "";
		for (int i = 0; i < s.length(); i++)
			sr = s.charAt(i) + sr;
		System.out.println(sr);
		System.out.println(s);
		return lcs(s,sr);	
	}
	
	
	public static String lcs(String a, String b) {
		if ( a == null || b == null) return null;
		if ( a.isEmpty() || b.isEmpty()) return "";
		int m = a.length();
		int n = b.length();
		int[][] f = new int[m + 1][n + 1];
		
		//initialization
		for (int i = 0; i <= m; i++)
			f[i][0] = 0;
		for (int j = 0; j <= n; j++)
			f[0][j] = 0;
		
		//process
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				if (a.charAt(i - 1) == b.charAt(j - 1))
					f[i][j] = f[i- 1][j - 1] + 1;
				else 
					f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
		
		if (f[m][n] == 0) return "";
		
		String res = "";
		int i = m;
		int j = n;
		while (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				res = a.charAt(i - 1) + res;
				i--; j--;
				continue;
			}
			if (f[i - 1][j] > f[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
//		String s = "BBABCBCAB";
//		String s = "GEEKS FOR GEEKS";
		String s = "forgeekskeegfor";
//		System.out.println(getLPS(s));
		System.out.println(getLPSbyLCS(s));
	}
}
