package FINAL;

import java.util.ArrayList;
import java.util.Collections;

public class Permutation {

	public static void run(String prefix, String s, ArrayList<String> res) {
		if (s.isEmpty()) {
			String clone = new String(prefix);
			if (!res.contains(clone))
				res.add(clone);
		} else
			for (int i = 0; i < s.length(); i++)
				run(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1), res);
	}
	
	public static ArrayList<String> getPerms(String s) {
		ArrayList<String> res = new ArrayList<String>();
		run("", s, res);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		String s = "42baar";
		ArrayList<String> res = getPerms(s);
		System.out.println(res.size());
		Collections.sort(res);
		for (String x : res)
			System.out.println(x);
		long endTime = System.currentTimeMillis();
		System.out.printf("exe time: %.3f", (endTime - startTime)/1000.0);
	}

}
