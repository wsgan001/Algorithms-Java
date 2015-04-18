import java.util.ArrayList;
import java.util.Arrays;

public class StringAndArray {

//	Implement an algorithm to determine if a string has all unique characters 
//	What if you can not use additional data structures?	
	public static boolean unique(String s) {
		int[] marked = new int[256];
		Arrays.fill(marked, 0);
		for (int i = 0; i < s.length(); i++) {
			int index = (int) s.charAt(i);
			if (marked[index] > 0) return false;
			marked[index]++;
		}
		return true;
		//if not using additional data structure, must use O(n^2)
	}
	
//	Design an algorithm and write code to remove the duplicate characters in 
//	a string without using any additional buffer NOTE: One or two additional 
//	variables are fine An extra copy of the array is not
//	FOLLOW UP
//	Write the test cases for this method	
	public static String removeDuplicate(String str) {
		char[] s = str.toCharArray();
		if (s == null || s.length < 2) 
			return new String(s);
		int len = s.length;
		
		int tail = 0;
		
		for (int i = 0; i < len - 1; i++) {
			int j;
			for (j = 0; j < tail; j++) {
				if (s[j] == s[i]) break;
			}
			if (j == tail) {
				s[tail] = s[i];
				tail++;
			}
		}
		return new String(s).substring(0, tail);
	}
	
	public static boolean unigram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		
		int[] c1 = new int[256];
		int[] c2 = new int[256];
		Arrays.fill(c1, 0);
		Arrays.fill(c2, 0);

		for (int i = 0; i < s1.length(); i++) 
			c1[(int)s1.charAt(i)]++;
		for (int i = 0; i < s2.length(); i++) 
			c2[(int)s2.charAt(i)]++;
		
		for (int i = 0; i < 256; i++)
			if (c1[i] != c2[i]) 
				return false;
		
		return true;
	}
	
//	Write a method to replace all spaces in a string with ‘%20’
	public static String replaceSpace(String s) {
		ArrayList<Character> re = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) 
			if (s.charAt(i) == ' ') {
				re.add('%');
				re.add('2');
				re.add('0');
			} else {
				re.add(s.charAt(i));
			}
		char[] str = new char[re.size()];
		for (int i = 0; i < re.size(); i++)
			str[i] = re.get(i);
		return new String(str);
		
	}
//	Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, 
//	write a method to rotate the image by 90 degrees Can you do this in place?	
//	
	public static void rotate(int[][] a) {
		int n = a.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++ ) {
				int offset = i - first;
				int top = a[first][i]; //save top
				
				//left -> top
				a[first][i] = a[last - offset][first];
				//bottom -> left
				a[last - offset][first] = a[last][last - offset];
				//right -> bottom
				a[last][last - offset] = a[i][last];
				//top -> right
				a[i][last] = top;
			}
		}
	}
	
//	Assume you have a method isSubstring which checks if one word is a 
//	substring of another Given two strings, s1 and s2, write code to check 
//	if s2 is a rotation of s1 using only one call to isSubstring 
//	(i e , “waterbottle” is a rotation of “erbottlewat”)
	
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) 
			return false;
		String s1s1 = s1 + s1;
		return s1s1.contains(s2);
	}
	
	public static void main(String[] args) {
		
//		System.out.println(unique("kionen"));
//		System.out.println(removeDuplicate("aaaaaaabbbbbaaaaaaaaaa"));
//		System.out.println(unigram("kieeenn","nieeke"));
//		System.out.println(replaceSpace("kiens"));
		int[][] a = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16},
		};
		rotate(a);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) 
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
			
		System.out.println(isRotation("waterbottle","erbottlewat"));
				
	}

}
