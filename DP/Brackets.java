package DP;

import java.util.HashMap;

public class Brackets {

	public static String res = "";
	
	public static int bracket(String s) {
		if (s == null || s.isEmpty())
			return 0;
		int n = s.length();
		int[][] f = new int[n + 1][n + 1];
		int[][] trace = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++) {
				f[i][j] = 0;
				trace[i][j] = -1;
			}
				
		HashMap<Character,Character> map = new HashMap<Character,Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		
		//initialization with len = 1
		for (int i = 1; i <= n; i++) {
			f[i][i] = 1;
			trace[i][i] = i;
		}
			
		
		//processing
		for (int len = 2; len <= n; len++)
			for (int i = 1; i <= n - len + 1; i++) {
				int j = i + len - 1;
				f[i][j] = f[i][j - 1] + 1;
//				trace[i][j] = j - 1;
				for (int k = i; k < j; k++) 
					if ( map.containsKey(s.charAt(k-1)) && map.get(s.charAt(k-1))==s.charAt(j-1)) {
						if (f[i][j] > f[i][k - 1] + f[k + 1][j - 1]) {
							f[i][j] = f[i][k - 1] + f[k + 1][j - 1];
							trace[i][j] = k;
						}
					}
					
			}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n;j++)
				System.out.print(trace[i][j] + " ");
			System.out.println();
		}
		if (f[1][n] == 0) 
			res = s;
		else
			backTracking(trace, s);	
		System.out.println(res);
		return f[1][n];
	}
	
	public static void run(int[][] t, String s, int i, int j) {
		if (i > j) return;
		if (i == j) {
			res = res + getPair(s.charAt(i-1));
			return;
		}
		if (t[i][j] == -1) {
			run(t, s, i, j - 1);
			res = res + getPair(s.charAt(j-1));
		} else {
			int k = t[i][j];
			run(t, s, i, k-1);
			res = s.charAt(k-1) + res;
			run(t, s, k+1, j-1);
			res = res + s.charAt(j-1);
		}
	}
	
	public static String getPair(char c) {
		if (c == '(' || c ==')') return "()";
		if (c == '[' || c ==']') return "[]";
		if (c == '{' || c =='}') return "{}";
		return "";
	}
	
	public static void backTracking(int[][] t, String s) {
		int i = 1;
		int j = s.length();
		run(t, s, i, j);
	}
	
	private static boolean isPaired(char i, char j) {
		// TODO Auto-generated method stub
		if (i == '(' && j == ')') return true;
		if (i == '[' && j == ']') return true;
		if (i == '{' && j == '}') return true;
		return false;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "([){{)(}]";
		String s = "{(})()[)]";
		System.out.println(bracket(s));
	}

}
