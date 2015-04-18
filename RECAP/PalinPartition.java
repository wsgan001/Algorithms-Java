package RECAP;

import java.util.ArrayList;

public class PalinPartition {

	
	//given string s, partition it in to smallest number of string such that all substring is palin
	public static ArrayList<String> palinPartition(String s) {
		ArrayList<String> res = new ArrayList<String>();
		
		int n = s.length();
		if (n == 0)
			return res;
		int[][] f = new int[n + 1][n + 1];
		int[][] tr= new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= i; j++) {
				f[i][j] = 0;
			}

		//initialization for len = 1;
		for (int i = 1; i <= n; i++) {
			f[i][i] = 1;
			tr[i][i] = i;
		}
		
		//procesing
		for (int len = 2; len <= n; len++)
			for (int i = 1; i <= n - len + 1; i++) {
				int j = i + len - 1;
				f[i][j] = f[i][j - 1] + 1;
				tr[i][j] = j;
				for (int k = i; k < j; k++) {
					if (isPalin(s.substring(k-1, j)) && f[i][j] > f[i][k - 1] + 1) {
						f[i][j] = f[i][k - 1] + 1;
						tr[i][j] = k;
					}
				}
			}
		System.out.println(f[1][n]);
		
		int i = 1; 
		int j = n;
		while (j >= 1) {
			int k = tr[i][j];
			res.add(0, s.substring(k - 1, j));
			j = k - 1;
		}
		
		return res;
	}
	
	public static boolean isPalin(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static void attemp(String s, ArrayList<String> x, ArrayList<ArrayList<String>> res) {
		if (s.isEmpty()) {
			res.add((ArrayList<String>) x.clone());
			return;
		}
		for (int i = 1; i <= s.length(); i++) {
			String first = s.substring(0, i);
			String second = s.substring(i, s.length());
			if (isPalin(first)) {
				x.add(first);
				attemp(second, x, res);
				x.remove(x.size() - 1);
			}
		}

	}
	
	//get all partition 
	public static ArrayList<ArrayList<String>> getAllPartition(String s) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> x = new ArrayList<String>();
		attemp(s, x, res);
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "ssksisksiskssskkiissk";
		String s = "abbaacdd";
		System.out.println(palinPartition(s));
		System.out.println("----All partition-----");
		ArrayList<ArrayList<String>> res = getAllPartition(s);
		for (ArrayList<String> x : res)
			System.out.println(x);
	}

}
