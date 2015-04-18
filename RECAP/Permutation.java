package RECAP;

import java.util.ArrayList;

public class Permutation {

	//Method 1: generate all perms in order
	public static void run(String prefix, String s, ArrayList<String> res) {
		if (s.isEmpty()) {
			res.add(prefix);
			return;
		}
		for (int i = 0; i < s.length(); i++)
			run(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1), res);
	}
	
	public static ArrayList<String> getPerms(String s) {
		ArrayList<String> res = new ArrayList<String>();
		run("", s, res);
		return res;
	}
	
	//Method 2 : MUCH FASTER
	public static ArrayList<String> getPerms2(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if (s.length() == 1) {
			res.add("" + s.charAt(0));
			return res;
		}
		ArrayList<String> prePerms = getPerms2(s.substring(0, s.length() - 1));
		for (String p : prePerms) 
			for (int i = 0; i <= p.length(); i++) {
				String newString = p.substring(0, i) + s.charAt(s.length() - 1) + p.substring(i);
				res.add(newString);
			}
				
		return res;
	}
	
	//given sequence number, return the permutation
	public static int[]  getPermFromId(int n, int k) {
		int[] res = new int[n];
		int[] fac = new int[n];
		fac[0] = 1;
		for (int i = 1; i < n; i++)
			fac[i] = fac[i- 1] * i;
		ArrayList<Integer> d = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++)
			d.add(i);
		
		for (int i = n-1; i >= 0; i--) {
			int j = 0;
			while (k > fac[i]) {
				k -= fac[i];
				j++;
			}
			res[n - i - 1] = d.get(j);
			d.remove(j);
		}
		return res;
	}
	
	//get sequence number from perm
	public static int getIdFromPerm(int n, int[] a) {
		int res = 0;
		int[] fac = new int[n];
		fac[0] = 1;
		for (int i = 1; i < n; i++)
			fac[i] = fac[i- 1] * i;
		ArrayList<Integer> d = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++)
			d.add(i);
		for (int i = 0; i < n; i++) {
			//considering a[i]
			//find postion of a[i] in d
			int j;
			for (j = 0; j < d.size(); j++)
				if (d.get(j) == a[i])
					break;
			res += (j) * fac[n - i - 1];
			d.remove(j);
		}
		return res + 1;
	}
	
	//find the next permutation
	public static int[] nextPerm(int[] a) {
		int n = a.length;
		if (n == 1) 
			return null;
		
		int[] res = new int[n];
		//find a[i] such that a[i-1] <
		int i = n - 2;
		for (i = n - 2; i >= 0; i--)
			if (a[i] < a[i + 1])
				break;
		if (i < 0)
			return null;
		
		//find the first a[j] that > a[i]
		int j = n - 1;
		for (j = n - 1; j > i; j--)
			if (a[j] > a[i])
				break;
		
		int temp = a[i]; a[i] = a[j]; a[j] = temp;
		int first = i + 1;
		int last = n - 1;
		while (first < last) {
			temp = a[first]; a[first] = a[last]; a[last] = temp;
			first++;
			last--;
		}
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		
		ArrayList<String> res = getPerms("1234567890");
//		for (String s : res)
//			System.out.println(s);
		System.out.println(res.size());
		
		long endTime = System.currentTimeMillis();
		long exeTime = endTime - startTime;
		System.out.printf("Execution time: %.3f \n", exeTime/1000.0);
		
		int[] p = getPermFromId(4, 1);
		for (int i : p)
			System.out.print(i + " ");
		System.out.println();
		System.out.println(getIdFromPerm(4, p));
		
		
		System.out.println("-----------------");
		int[] a = {1,3,5,6,4,2};
		int[] next = nextPerm(a);
		for (int i : next)
			System.out.print(i + " ");
	}

}
