package FINAL;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset {

	private static ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> a, int n) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (n == 0) {
			//return empty set
			res.add(new ArrayList<Integer>());
			return res;
		}
		
		ArrayList<ArrayList<Integer>> old = getAllSubsets(a, n - 1);
		for (ArrayList<Integer> x : old) {
			ArrayList<Integer> newSet = (ArrayList<Integer>) x.clone(); 
			newSet.add(a.get(n - 1));
			res.add(newSet);
		}
		res.addAll(old);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(4);
		ArrayList<ArrayList<Integer>> res = getAllSubsets(a, a.size());
		for (ArrayList<Integer> x : res) {
			for (int i : x)
				System.out.print(i + " ");
			System.out.println();
		}
		
		
	}


}
