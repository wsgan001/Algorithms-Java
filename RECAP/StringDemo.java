package RECAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class StringDemo {
//	Finding the longest palindromic substring is a classic problem of coding interview
//	Note: considering consecutive chars in string only
	public static String lps(String s) {
		if (s == null || s.length() < 1) 
			return "";
		String res = s.substring(0, 1);
		
		for (int i = 0; i < s.length() - 1; i++) {
			String str = helper(s, i, i);
			if (res.length() < str.length())
				res = str;
			str = helper(s, i, i + 1);
			if (res.length() < str.length())
				res = str;
		}
		return res;
	}
	
	public static String helper(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		return s.substring(i + 1, j);
	}
	
//	Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//	For example, given
//	s = "leetcode",
//	dict = ["leet", "code"].
//	Return true because "leetcode" can be segmented as "leet code".
	
	public static boolean wordBreak(String s, Set<String> dict) {
		if (s.length() == 0 || dict.size() == 0) 
			return false;
		int n = s.length();
		int[] f = new int[n + 1];
		f[0] = 1;
		for (int i = 1; i <= n; i++) {
			f[i] = 0;
			for (String word : dict)  {
				int begin = i - word.length();
				if (begin < 0) 
					continue;
				if (f[begin] != 0 && s.substring(begin,i).equals(word))
					f[i] = begin + 1;
			}
		}
		
		if (f[n] != 0) {
			Stack<String> res = new Stack<String>();
			int i = n;
			while (i != 0) {
				res.push(s.substring(f[i] - 1,i));
				i = f[i] - 1;
			}
			while (!res.isEmpty())
				System.out.println(res.pop());
		}
		return f[n] != 0 ? true : false;
	}
	
	
	public static void getAllWordBreak(String s, Set<String> dict, Stack<String> res) {
		if (s.isEmpty()) {
			System.out.println(res);
			return;
		}
		for (String st : dict)
			if (s.startsWith(st)) {
				res.push(st);
				getAllWordBreak(s.substring(st.length()), dict, res);
				res.pop();
			}
	}
	
	
//	Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
//	Only one letter can be changed at a time
//	Each intermediate word must exist in the dictionary
//	For example,
//	Given:
//	start = "hit"
//	end = "cog"
//	dict = ["hot","dot","dog","lot","log"]
//	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//	return its length 5.
//	Note:
//	Return 0 if there is no such transformation sequence.
//	All words have the same length.
//	All words contain only lowercase alphabetic characters.
	public static boolean wordLadder(String start, String end, Set<String> dict) {
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		Stack<String> was = new Stack<String>();
		was.push(start);
		HashMap<String, String> trace = new HashMap<String, String>();
		while (!queue.isEmpty()) {
			String s = queue.poll();
			for (String v : dict)
				if (!was.contains(v) && connected(s, v)) {
					queue.add(v);
					was.add(v);
					trace.put(v, s);
					if (v.equals(end)) {
						//print trace
						while (!v.equals(start)) {
							System.out.println(v);
							v = trace.get(v);
						}
						return true;
					} 
				}
		}
		return false;
	}
	
	public static boolean connected(String s, String v) {
		if (s.length() != v.length()) 
			return false;
		int count = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) != v.charAt(i)) {
				count++;
				if (count > 1) 
					return false;
			}
		return true;
	}
	
	//given a string, find the longest consecutive substring such that it has no-repeated char
	public static String getNoRepeatSub(String s) {
		if (s.isEmpty()) 
			return "";
		int maxLen = 0;
		int start = 0;
		int lastIndex = 0;
		HashMap<Character, Integer> pos = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (pos.containsKey(c)) {
				int j = pos.get(c);
				if (j >= start)
					start = j + 1;
				pos.remove(c);
				pos.put(c,i);
			} else {
				pos.put(c, i);
			}
			if (maxLen < i - start + 1) {
				maxLen = i - start + 1; 
				lastIndex = i;
			}
		}
		System.out.println(maxLen);		
		return s.substring(lastIndex - maxLen + 1, lastIndex + 1);
	}
	
	
	public static boolean hasUniqueChars(String s) {

//		boolean[] was = new boolean[255];
//		Arrays.fill(was, false);
//		for (int i = 0; i < s.length(); i++) {
//			int c = s.charAt(i) - (int)'a';
//			if (was[c])
//				return false;
//			was[c] = true;
//		}
//		return true;
		
		//if no additional space allowed.
		int n = s.length();
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (s.charAt(i) == s.charAt(j))
					return false;
		return true;
	}
	
	
	//remove duplicated of a string. No additional space
	public static String removeDup(String s) {
		int n = s.length();
		if (n <= 1)
			return s;
		
		char[] a = s.toCharArray();
		int index = 1;
		for (int i = 1; i < n; i++) {
			int j = 0;
			for (j = 0; j < index; j++)
				if (a[i] == a[j])
					break;
			if (j == index)
				a[index++] = a[i];
		}
		
		return String.valueOf(a).substring(0, index);
	}
	
	//check if two strings are anagrams
	public static boolean isAnagram(String sa, String sb) {
		if (sa.length() != sb.length())
			return false;
		int n = sa.length();
		int[] a = new int[255];
		int[] b = new int[255];
		Arrays.fill(a, 0);
		Arrays.fill(b, 0);
		
		for (int i = 0; i < n; i++) {
			int c = sa.charAt(i) - 'a';
			a[c]++;
			c = sb.charAt(i) - 'a';
			b[c]++;
		}
		
		for (int i = 0; i < 255; i++)
			if (a[i] != b[i])
				return false;
		
		return true;
	}
	
	//method to sort list of string such that all anagram string stand next to each other
	public static void sortStrings(String[] a) {
		Arrays.sort(a, new AnagramComparator());
	}
	
	//String pattern
	public static ArrayList<Integer> getAllPos(String s, String p) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (s.length() < p.length())
			return res;
		
		for (int i = 0; i <= s.length() - p.length(); i++) {
			int j;
			for (j = 0; j < p.length(); j++)
				if (s.charAt(i + j) != p.charAt(j))
					break;
			if (j == p.length())
				res.add(i);
		}
		return res;
	}
	
	//String pattern using KMP algorithm
	public static ArrayList<Integer> getAllPosKMP(String s, String p) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int n = s.length();
		int m = p.length();
		if (n < m)
			return res;
		
//		construct the longest surfix-prefix array of pattern p
		int[] lsp = new int[m];
		lsp[0] = 0;
		int start = 0;
		for (int i = 1; i < m; i++)
			if (p.charAt(i) == p.charAt(start)) {
				lsp[i] = lsp[i - 1] + 1;
				start++;
			} else {
				start = 0;
				if (p.charAt(i) == p.charAt(0)) {
					lsp[i] = 1;
					start++;
				}
				else
					lsp[i] = 0;
			}
		
		//processing
		int j = 0; //number of matched char
		for (int i = 0; i < n; i++) {
			//if not matching
			if (j > 0 && s.charAt(i) != p.charAt(j)) {
				j = lsp[j - 1];
				//note: not using 'continue' here.
			}
			//if matching
			if (s.charAt(i) == p.charAt(j)) {
				j++;
				if (j == m) {
					res.add(i - m);
					j = 0;
				}
					
			}
				
		}
//		for (int i = 0; i < m; i++)
//			System.out.print(lsp[i] + " " );
		return res;
	}
	
	public static void main(String[] args) {
//		find longest palindrome
//		System.out.println(lps("121ababccba1"));
		
		//wordBreak
//		String s = "leetcode";
//		Set<String> dict = new HashSet<String>();
//		dict.add("leet");
//		dict.add("code");
//		String s = "pmcek";
//		Set<String> dict = new HashSet<String>();
//		dict.add("pmce");
//		dict.add("pm");
//		dict.add("cek");
//		System.out.println(wordBreak(s, dict));
//		Stack<String> res = new Stack<String>();
//		getAllWordBreak(s, dict, res);
		
//		----------------------------------------------------------------------------------
//		String start = "hit";
//		String end = "cog";
//		String elements[] = { "hot", "dot", "dog", "lot", "log", "cog" };
//		
//	    HashSet<String> dict = new HashSet(Arrays.asList(elements));
//		System.out.println(wordLadder(start,end,dict));
//		----------------------------------------------------------------------------------
		
//		String s = "ABCDEFASDGKF";
//		System.out.println(getNoRepeatSub(s));
		
//		----------------------------------------------------------------------------------		
//		System.out.println(hasUniqueChars("trantrungkie"));
//		----------------------------------------------------------------------------------		
//		System.out.println(removeDup("trantrunga"));
//		----------------------------------------------------------------------------------		
//		System.out.println(isAnagram("tran","nrta"));
//		----------------------------------------------------------------------------------
//		String[] a = new String[3];
//		a[0] = "kien";
//		a[1] = "trung";
//		a[2] = "niek";
//		sortStrings(a);
//		for (int i = 0; i < 3; i++)
//			System.out.print(a[i] + " ");
//		System.out.println();
//		----------------------------------------------------------------------------------
		//STRING PATTERN
		String s = "aabdabeabdabf";
		String p = "abdabf";
		ArrayList<Integer> res = getAllPosKMP(s, p);
		for (int i : res)
			System.out.print(i + " ");
	}
}



class AnagramComparator implements Comparator<String> {
	
	public String sortChars(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return String.valueOf(a);
	}
	
	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}
}
