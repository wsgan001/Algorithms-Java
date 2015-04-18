package Recursion;

import java.util.ArrayList;

public class PalindromePartitioning {
//	Given a string s, partition s such that every substring of the partition is a palindrome.
	public static ArrayList<ArrayList<String>> getAllPalindromePartition(String s) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ArrayList<String> x = new ArrayList<String>();
		run(s, x, res);
		return res;
	}
	
	public static void run(String s, ArrayList<String> x, ArrayList<ArrayList<String>> res) {
		if (s == null) 
			return;
		if (s.isEmpty()) {
			ArrayList<String> success = (ArrayList<String>) x.clone();
			res.add(success);
			return;
		}
		for (int i = 1; i <= s.length(); i++) {
			String first = s.substring(0, i);
			String last = s.substring(i, s.length());
			if (isPalindrome(first)) {
				x.add(first);
				run(last, x, res);
				x.remove(x.size() - 1);
			}
		}
	}
	
	public static boolean isPalindrome(String s) {
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		
		String s = "aabbbacddcabddbaaabbaabbbacddckkkk";
		ArrayList<ArrayList<String>> res = getAllPalindromePartition(s);
//		for (ArrayList<String> x : res) {
//			System.out.println(x);
//		}
		System.out.println(res.size());
		
		long endTime = System.currentTimeMillis();
		long exeTime = endTime - startTime;
		System.out.printf("execution time: %.3f", exeTime/1000.0);
	}

}
