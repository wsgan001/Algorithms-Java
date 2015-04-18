import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

//Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
//
//Only one letter can be changed at a time
//Each intermediate word must exist in the dictionary
//For example,
//
//Given:
//start = "hit"
//end = "cog"
//dict = ["hot","dot","dog","lot","log"]
//As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.
//
//Note:
//Return 0 if there is no such transformation sequence.
//All words have the same length.
//All words contain only lowercase alphabetic characters.

public class WordLadder {
	
	public static boolean wordLadder(String start, String end, HashSet<String> dict) {
		//declaration
		ArrayList<String> queue = new ArrayList<String>();
		int n = dict.size();
		int[] trace = new int[n + 1];
		for (int i = 0;i < n+1; i++) {
			trace[i] = -1;
		}
		//initialization
		queue.add(start);
		int top = 0, rear = 0;
		trace[0] = 0;
		//processing BFS
		while (rear <= top) {
			String v = queue.get(rear);
			rear++;
			for (String a: dict) {
				if (connected(a,v) && !queue.contains(a)) {
					if (a.equals(end)) {
						queue.add(a); top++;
						trace[top] = rear-1;
						System.out.println(queue);
						
						//print result
						int k = top;
						
						while (k != trace[k]) {
							System.out.print(queue.get(k) +"<---");
							k = trace[k];
						}
						System.out.println(queue.get(k));
						return true;
					}
					queue.add(a); top++;
					trace[top] = rear-1;
				}
			}
		}
		System.out.println(queue);
		return false;
	}
	
	public static boolean connected(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		int countDif = 0;
		for (int i = 0;i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				countDif++;
				if (countDif > 1) return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		String elements[] = { "hot", "dot", "dog", "lot", "log", "cog" };
		
	    HashSet<String> dict = new HashSet(Arrays.asList(elements));
		System.out.println(wordLadder(start,end,dict));
	}

}
