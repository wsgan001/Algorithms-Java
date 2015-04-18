//Given an array of 0s and 1s, find the position of 0 to be replaced with 1 to get longest continuous sequence of 1s. Expected time complexity is O(n) and auxiliary space is O(1).
//Example:
//
//Input: 
//   arr[] =  {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1}
//Output:
//  Index 9
//Assuming array index starts from 0, replacing 0 with 1 at index 9 causes
//the maximum continuous sequence of 1s.
//
//Input: 
//   arr[] =  {1, 1, 1, 1, 0}
//Output:
//  Index 4


public class Longest1Elements {

	public static int findIndex(int[] a) {
		if (a == null || a.length == 0)
			return -1;
		int n = a.length;
		
		if (n == 1) 
			if (a[0] == 0) return 0;
			else return -1;
		
		int[] left = new int[n];
		left[0] = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] == 0)
				left[i] = 0;
			else
				left[i] = left[i - 1] + 1;
		}
		
		int[] right = new int[n];
		right[n - 1] = a[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (a[i] == 0)
				right[i] = 0;
			else
				right[i] = right[i + 1] + 1;
		}
		
		int maxLength = 0;
		int res = -1;
		//consider first position
		if (a[0] == 0 && maxLength < right[1]) {
			maxLength = right[1] + 1;
			res = 0;
		}
		//consider last position
		if (a[n-1] == 0 && maxLength < left[n-2]) {
			maxLength = left[n-2] + 1;
			res = n-1;
		}
		for (int i = 1; i < n - 1; i++)
			if (a[i] == 0 && maxLength < left[i - 1] + right[i + 1]) {
				maxLength = left[i - 1] + right[i + 1] + 1;
				res = i;
			}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		int[] a = {1,1,1,0};
		System.out.println(findIndex(a));
	}

}
