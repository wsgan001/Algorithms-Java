package RECAP;

import java.util.Arrays;

public class Brackets {

	public static String res = "";
	
	public static int bracket(String s) {
		int n = s.length();
		if (n == 0)
			return 0;
		//f[i][j] is the minimum bracket need added for sub string s[i]..s[j]
		int[][] f = new int[n + 1][n + 1];
		int[][] tr = new int[n + 1][n + 1];
		
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++) {
				f[i][j] = 0;
				tr[i][j] = -1;
			}
		
		for (int i = 1; i <= n; i++)
			f[i][i] = 1;
		for (int len = 2; len <= n; len++) 
			for (int i = 1; i <= n - len + 1; i++) {
				int j = i + len - 1;
				f[i][j] = f[i][j - 1] + 1;
				for (int k = i; k < j; k++) 
					if (isMatch(s.charAt(k - 1), s.charAt(j - 1)) && f[i][j] > f[i][k - 1] + f[k + 1][j - 1]) {
						f[i][j] = f[i][k - 1] + f[k + 1][j - 1];
						tr[i][j] = k;
					}
			}
		
		tracing(s, tr);
		System.out.println(res);
		return f[1][n];
	}
	
	public static void tracing(String s, int[][] tr) {
		int n = s.length();
		run(1, n, s, tr);
	}
	
	public static void run(int i, int j, String s, int[][] tr) {
		int k = tr[i][j];
		if (i > j)
			return;
		if (i == j) {
			res = res + getPair(s.charAt(i-1));
			return;
		}
		if (tr[i][j] == -1) {
			run(i, j - 1, s, tr);
			res = res + getPair(s.charAt(j-1));
		} else {
			run(i, k - 1, s, tr);
			res = s.charAt(k - 1) + res;
			run(k + 1, j - 1, s, tr);
			res = res + s.charAt(j - 1);
		}
	}
	
	public static String getPair(int c) {
		if (c == '(' || c == ')')
			return "()";
		if (c == '{' || c == '}')
			return "{}";
		if (c == '[' || c == ']')
			return "[]";
		return "";
	}
	
	public static boolean isMatch(char l, char r) {
		if (l == '(' && r ==')')
			return true;
		if (l == '[' && r ==']')
			return true;
		if (l == '{' && r =='}')
			return true;
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{(})()[)]";
		System.out.println(bracket(s));
	}

}
