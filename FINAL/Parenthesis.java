package FINAL;

import java.util.ArrayList;

public class Parenthesis {

	public static void run(int i, int l, int r, char[] x, ArrayList<String> res) {
		if (l > r || i == x.length) {
			res.add(String.valueOf(x));
			return;
		}
			
		if (l > 0) {
			x[i] = '(';
			run(i + 1, l - 1, r, x, res);
		}
		if (l < r) {
			x[i] = ')';
			run(i + 1, l , r - 1, x, res);
		}
	}
	
	public static ArrayList<String> getAllParenthesis(int n) {
		ArrayList<String> res = new ArrayList<String>();
		if (n % 2 == 1)
			return res;
		
		char[] x = new char[n];
		run(0, n / 2, n / 2, x, res);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		ArrayList<String> res = getAllParenthesis(n);
		for (String x : res) {
			System.out.println(x);
		}
	}

}
