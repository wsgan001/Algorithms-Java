package RECAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subset {

	public static ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> s, int n) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (n == 0) {
			ArrayList<Integer> empty = new ArrayList<Integer>();
			res.add(empty);
			return res;
		}
		ArrayList<ArrayList<Integer>> preSet = getSubset(s, n - 1);
		res.addAll(preSet);
		for (ArrayList<Integer> set : preSet) {
			ArrayList<Integer> newSet = (ArrayList<Integer>) set.clone();
			newSet.add(s.get(n - 1));
			res.add(newSet);
		}
		return res;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubset2(ArrayList<Integer> s) {
		int n = s.size();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		long max = 1 << n;
		for (int i = 0; i < max; i++) {
			ArrayList<Integer> set = new ArrayList<Integer>();
			for (int j = 0; j < n; j++)
				if (getBit(i, j) == 1) 
					set.add(s.get(j));
			res.add(set);
		}
		return res;
	}
	
	public static int getBit(int n, int i) {
		return 1 & (n >> i);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		
		ArrayList<Integer> s = new ArrayList<Integer>();
		for (int i = 1; i <= 4; i++)
			s.add(i);
		ArrayList<ArrayList<Integer>> sets = getSubset2(s);
//		ArrayList<ArrayList<Integer>> sets = getSubset(s, s.size());
		
		long endTime = System.currentTimeMillis();
		
//		for (ArrayList<Integer> i : sets) {
//			System.out.println(i);
//		}
		System.out.printf("%.3f \n", (endTime - startTime) / 1000.0);
		System.out.println(sets.size());
	}

}
