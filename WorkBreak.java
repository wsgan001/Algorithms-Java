import java.awt.*;
import java.util.*;

//Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//For example, given
//s = "leetcode",
//dict = ["leet", "code"].
//Return true because "leetcode" can be segmented as "leet code".

public class WorkBreak {
	
	public static int wordBreak_check(String s, Set<String> dict) {
		int n = s.length();
		int[] trace = new int[n+1];
		Stack<String> frag = new Stack<String>();
		//trace[i]=previous position that construct a word if s[0..i-1] can be segmented.
		for (int i = 1;i < n; i++) {
			trace[i] = -1;
		}
		trace[0] = 0;
		
		for (int i = 1;i <= n; i++) {
			for(String a: dict) {
				int begin = i-a.length();
				if (begin < 0) continue;
				
				if (trace[begin]!=-1 && s.substring(begin, i).equals(a)) {
					trace[i] = begin;
				}
			}
		}
//		for (int i = 0;i < n; i++) System.out.print(trace[i]+ " ");
		
		if (trace[n] != -1) {  //print result
			int end = n; 
			
			while (end > 0) {
				frag.push(s.substring(trace[end], end));
				end = trace[end];
			}
		}
		
		while (!frag.isEmpty()) {
			System.out.print(frag.pop()+ " ");
		}
		return trace[n];
	}
	
	public static void wordBreak_all(String s, Set<String> dict, Stack<String> results) {
		if (s.isEmpty()) System.out.println(results);
		for (String a: dict) {
			if (s.startsWith(a)) {
				results.push(a);
				wordBreak_all(s.substring(a.length(),s.length()), dict, results);
				results.pop();
			}
		}
	}
	
	public static void main(String[] args) {
		String s = "programcreek";
		Set<String> dict = new HashSet<String>();
		dict.add("programcree");
		dict.add("program");
		dict.add("prog");
		dict.add("ram");
		dict.add("creek");
		dict.add("cre");
		dict.add("ek");
		dict.add("k");
		System.out.println(dict);
		
		Stack<String> re = new Stack<String>();
		wordBreak_all(s,dict, re);
	}

}
