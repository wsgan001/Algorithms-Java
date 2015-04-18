package DP;

import java.util.ArrayList;
import java.util.HashSet;

//Longest Common Substring
public class LCS {

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
			if (a.charAt(i - 1) == b.charAt( j - 1)) {
				res = a.charAt(i - 1) + res;
				i--; j--;
				continue;
			}
			if (f[i - 1][j] > f[i][j - 1]) {
				i--;
			} else 
				j--;
		}
		return res;
	}
	
	public static HashSet<String> getAll(String a, String b) {
		HashSet<String> res = new HashSet<String>();
		if (a == null || a.isEmpty() || b == null || b.isEmpty()) return res;
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
		
		if (f[m][n] == 0) return res;
		
		res = backTracking(f, a, b);
		
		return res;
	}
	
	public static void run(int[][] f, String x, String a, String b, int i, int j, HashSet<String> res) {
		if (i == 0 || j == 0) {
			String s = new String(x);
			res.add(s);
			return;
		}
		if (f[i][j] == f[i - 1][j - 1] + 1 && a.charAt(i - 1) == b.charAt(j - 1)) {
			x = a.charAt(i - 1) + x;
			run(f, x, a, b, i - 1, j - 1, res);
			x = x.substring(1, x.length());
			return;
		}
		if (f[i][j] == f[i][j - 1]) {
			run(f, x, a, b, i, j - 1, res);
		}
		if (f[i][j] == f[i - 1][j]) {
			run(f, x, a, b, i - 1, j, res);
		}
	
	}
	
	public static HashSet<String> backTracking(int[][] f, String a, String b) {
		HashSet<String> res = new HashSet<String>();
		int m = a.length();
		int n = b.length();
		String x = "";
		run(f, x, a, b, m, n, res);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "1232abc";
		String b = "rutyac3212";
		String s = "GEEKS FOR GEEKS";
		String sr = "";
		for (int i = 0; i < s.length(); i++)
			sr = s.charAt(i) + sr;
//		System.out.println(lcs(a, b));
		HashSet<String> res = getAll(s, sr);
		for (String s1 : res) 
			System.out.println(s1);
	}

}
