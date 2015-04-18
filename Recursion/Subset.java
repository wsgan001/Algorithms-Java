package Recursion;

import java.util.ArrayList;
import java.util.HashSet;

//print all subset of a set with n elements.
public class Subset {

	public static ArrayList<ArrayList<Integer>> subset(int n) {
		ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
		if (n == 1) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(1);
			re.add(list);
			return re;
		}
			
		ArrayList<ArrayList<Integer>> a = subset(n - 1);
		re.addAll(a);
		for (ArrayList<Integer> i : a) {
			ArrayList<Integer> inew = (ArrayList<Integer>) i.clone();
			inew.add(n);
			re.add(inew);
		}
		
		//add itself
		ArrayList<Integer> it = new ArrayList<Integer>();
		it.add(n);
		re.add(it);
		
		return re;
	}
	
	
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int n) {
		ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
		if (n == 0) {
			ArrayList<Integer> empty = new ArrayList<Integer>();
			re.add(empty);
			return re;
		}
		ArrayList<ArrayList<Integer>> oldSubsets = getSubsets(set, n - 1);
		re.addAll(oldSubsets);
		for (ArrayList<Integer> s : oldSubsets) {
			ArrayList<Integer> newSet = (ArrayList<Integer>) s.clone();
			newSet.add(set.get(n - 1));
			re.add(newSet);
		}
		return re;
	}

//	public static HashSet<ArrayList<Integer>> getSubsetsNoDup(ArrayList<Integer> set, int n) {
//		HashSet<ArrayList<Integer>> re = new HashSet<ArrayList<Integer>>();
//		if (n == 0) {
//			ArrayList<Integer> empty = new ArrayList<Integer>();
//			re.add(empty);
//			return re;
//		}
//		HashSet<ArrayList<Integer>> oldSubsets = getSubsetsNoDup(set, n - 1);
//		re.addAll(oldSubsets);
//		for (ArrayList<Integer> s : oldSubsets) {
//			ArrayList<Integer> newSet = (ArrayList<Integer>) s.clone();
//			newSet.add(set.get(n - 1));
//			re.add(newSet);
//		}
//		return re;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<ArrayList<Integer>> re = subset(5);
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(2);
		set.add(4);		
		ArrayList<ArrayList<Integer>> re = getSubsets(set, set.size());
		for (ArrayList<Integer> subset : re) {
			for (int i : subset)
				System.out.print(i + " ");
			System.out.println();
		}
	}

}
