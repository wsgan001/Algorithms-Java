import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class twoSum {

	public static HashSet<ArrayList<Integer>> twoSum(int[] a) {
		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
//		Arrays.sort(a);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < a.length; i++) {
			int p = -a[i];
			if (map.containsKey(p)) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				temp.add(map.get(p));
				result.add(temp);
			} else {
				map.put(a[i], i);
			}
		}
		return result;
	}
	
	public static ArrayList<ArrayList<Integer>> twoSum_arraylist(int[] a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//		Arrays.sort(a);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < a.length; i++) {
			int p = -a[i];
			if (map.containsKey(p)) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				temp.add(map.get(p));
				result.add(temp);
			} else {
				map.put(a[i], i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		
//		int[] a = {1,-1,0,0,0,1,2,-2};
		int[] a = new int[1000000];
		for (int i = 0; i < a.length; i++) 
			a[i] = (int) (Math.random()*100 - 50);
		HashSet<ArrayList<Integer>> re = new HashSet<ArrayList<Integer>>();
		re = twoSum(a);
		System.out.println(re.size());

		ArrayList<ArrayList<Integer>> re1 = new ArrayList<ArrayList<Integer>>();
		re1 = twoSum_arraylist(a);
		System.out.println(re1.size());
		
//		for (ArrayList<Integer> group2: re) {
//			for (int i: group2) System.out.print(i + " ");
//			System.out.println();
//		}
		
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("Time elapsed: " + elapsedTime + " ms");
		
	}

}
