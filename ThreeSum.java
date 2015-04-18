import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.math.*;


public class ThreeSum {

	public static ArrayList<ArrayList<Integer>> threeSum(int[] a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (a.length < 3)
			return result;
		
		Arrays.sort(a);
//		for (int i = 0; i < a.length; i++) System.out.print(a[i] + " ");System.out.println();
		for (int i = 0; i < a.length - 2; i++) {
			int negative = -a[i];
			if (i == 0 || a[i] > a[i - 1]) {
				int begin = i + 1;
				int end = a.length - 1;
				while (begin < end) {
					if (a[begin] + a[end] == negative) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(a[i]);
						temp.add(a[begin]);
						temp.add(a[end]);
						if (!result.contains(temp)) 
							result.add(temp);
						begin++;
						end--;
						//avoid the duplicate
//						while (begin < end && a[begin] == a[begin + 1]) begin++;
//						while (begin < end && a[end] == a[end - 1]) end--;
					} else if (a[begin] + a[end] > negative) {
						end--;
					} else {
						begin++;
					}
				}
			}
		}
		return result;
	}

	public static HashSet<ArrayList<Integer>> threeSum_hashset(int[] a) {
		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
		if (a.length < 3)
			return result;
		
		Arrays.sort(a);
//		for (int i = 0; i < a.length; i++) System.out.print(a[i] + " ");System.out.println();
		for (int i = 0; i < a.length - 2; i++) {
			int negative = -a[i];
			if (i == 0 || a[i] > a[i - 1]) {
				int begin = i + 1;
				int end = a.length - 1;
				while (begin < end) {
					if (a[begin] + a[end] == negative) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(a[i]);
						temp.add(a[begin]);
						temp.add(a[end]);
//						if (!result.contains(temp)) 
							result.add(temp);
						begin++;
						end--;
						//avoid the duplicate
//						while (begin < end && a[begin] == a[begin + 1]) begin++;
//						while (begin < end && a[end] == a[end - 1]) end--;
					} else if (a[begin] + a[end] > negative) {
						end--;
					} else {
						begin++;
					}
				}
				
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = {-1,-1,-1,0,0,0,0,0,1,1,1,1,2,-2};
		long startTime = System.currentTimeMillis();
		
		int[] a = new int[99];
		for (int i = 0; i < a.length; i++)
			a[i] = (int) (Math.random()*100 - 50);
		ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
		re = threeSum(a);
		System.out.println(re.size());
		
		HashSet<ArrayList<Integer>> re1 = new HashSet<ArrayList<Integer>>();
		re1 = threeSum_hashset(a);
		System.out.println(re1.size());
		
//		for (ArrayList<Integer> group3 : re) {
//			for (int i : group3) System.out.print(i + " ");
//			System.out.println();
//		}
		
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("Time elapsed: " + elapsedTime + " ms");
	}

}
