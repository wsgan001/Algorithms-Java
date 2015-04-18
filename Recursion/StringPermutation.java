package Recursion;

import java.util.ArrayList;

public class StringPermutation {

	public static ArrayList<String> getPerms(String s) {
		ArrayList<String> re = new ArrayList<String>();
		if (s.length() == 1) {
			String s1 = s.substring(0, 1);
			re.add(s1);
			return re;
		}
		ArrayList<String> oldPerms = getPerms(s.substring(0,s.length() - 1));
		for (String s1 : oldPerms) {
			for (int i = 0; i <= s1.length(); i++) {
				String first = s1.substring(0, i);
				String second = s1.substring(i, s1.length());
				String newString = first + s.charAt(s.length() - 1) + second;
				re.add(newString);
			}
		}
		return re;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1234567890";
		
		long startTime = System.currentTimeMillis();
		ArrayList<String> perms = getPerms(s);
//		for (String s1 : perms) 
//			System.out.println(s1);
		System.out.println(perms.size());
		long endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - startTime)/1000.0);
	}

}
