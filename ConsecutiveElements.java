import java.util.HashSet;

//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be 
//[1, 2, 3, 4]. Its length is 4.

public class ConsecutiveElements {

	public static int longestConsecutive(int[] a) {
		if (a.length == 0) 
			return 0;
		int max = 1;
		
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++)
			set.add(a[i]);
		for (int i = 0; i < a.length; i++) {
			int count = 1;
			int begin = a[i] - 1;
			while (set.contains(begin)) {
				set.remove(begin);
				begin--;
				count++;
			}
			
				
			int end = a[i] + 1;
			while (set.contains(end)) {
				set.remove(end);
				end++;
				count++;
			}
			
			
			max = Math.max(max, count);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {6,10,2,7,5,9,3};
//		int n = 10;
//		int[] a = new int[n];
		System.out.println(longestConsecutive(a));
	}

}
