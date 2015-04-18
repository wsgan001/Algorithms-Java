package RECAP;

import java.util.ArrayList;

public class LCS {

	public static String lcs(String a, String b) {
		String res = "";
		
		int m = a.length();
		int n = b.length();
		if (m * n == 0)
			return res;
		
		int[][] f = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			f[i][0] = 0;
		for (int j = 0; j <= n; j++)
			f[0][j] = 0;
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) 
				if (a.charAt(i - 1) == b.charAt(j - 1))
					f[i][j] = f[i - 1][j - 1] + 1;
				else
					f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]);
		
		System.out.println(f[m][n]);
		int i = m;
		int j = n;
		while (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				res = a.charAt(i - 1) + res;
				i--;
				j--;
			} else {
				if (f[i][j] == f[i][j - 1])
					j--;
				else
					i--;
			}
		}
		return res;
	}
	
	public static ArrayList<String> getAllLCS(String a, String b) {
		ArrayList<String> res = new ArrayList<String>();
		
		int m = a.length();
		int n = b.length();
		if (m * n == 0)
			return res;
		
		int[][] f = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			f[i][0] = 0;
		for (int j = 0; j <= n; j++)
			f[0][j] = 0;
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) 
				if (a.charAt(i - 1) == b.charAt(j - 1))
					f[i][j] = f[i - 1][j - 1] + 1;
				else
					f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]);
		
		//tracing
		String x = "";
		run(x, m, n, a, b, f, res);
		return res;
	}
	
	public static void run(String x, int i, int j, String a, String b, int[][] f, ArrayList<String> res) {
		if (i == 0 || j == 0) {
			if (!res.contains(x))
				res.add(new String(x));
			return;
		}
		if (i > 0 && j > 0) 
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				x = a.charAt(i - 1) + x;
				run(x, i - 1, j - 1, a, b, f, res);
				x = x.substring(1, x.length());
			} else {
				if (f[i][j] == f[i][j - 1]) 
					run(x, i, j - 1, a, b, f, res);
				if (f[i][j] == f[i - 1][j]) 
					run(x, i - 1, j, a, b, f, res);
			}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "123abegh";
		String b = "2a3b1geh";
//		String s = lcs(a,b);
//		System.out.println(s);
		ArrayList<String> res = getAllLCS(a, b);
		for (String x : res)
			System.out.println(x);

	}

}
