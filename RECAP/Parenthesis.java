package RECAP;

import java.util.ArrayList;

public class Parenthesis {

	public static void run(int left, int right, int i, char[] x, ArrayList<String> res) {
		if (left > right)
			return;
		if (left == 0 && right == 0) {
			res.add(String.valueOf(x.clone()));
			return;
		}
		if (left > 0) {
			x[i] = '(';
			run(left - 1, right, i + 1, x, res);
		}
		if (left < right) {
			x[i] = ')';
			run(left, right - 1, i + 1, x, res);
		}
	}
	
	public static ArrayList<String> parenthesis(int n) {
		// TODO Auto-generated method stub
		ArrayList<String> res = new ArrayList<String>();
		char[] x = new char[2*n];
		run(n, n, 0, x, res);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> res = parenthesis(4);
		for (String s : res) 
			System.out.println(s);
	}



}
