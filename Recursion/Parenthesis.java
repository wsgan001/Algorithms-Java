package Recursion;

import java.util.ArrayList;

public class Parenthesis {

	public static void run(int l, int r, char[] str, int index, ArrayList<String> re) {
		if (l < 0 || r < l) return;  //invalid state
		if (l == 0 && r == 0) {
			re.add(String.valueOf(str));
		} else {
			if (l > 0) {
				str[index] = '(';
				run(l - 1, r, str, index + 1, re);
			}
			if (l < r) {
				str[index] = ')';
				run(l, r - 1, str, index + 1, re);
			}
		}
		
	}
	
	public static ArrayList<String> getParenthesis(int n) {
		ArrayList<String> re = new ArrayList<String>();
		char[] str = new char[2*n];
		run(n, n, str, 0, re);
		return re;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> re = getParenthesis(4);
		for (String s : re) 
			System.out.println(s);
	}

}
