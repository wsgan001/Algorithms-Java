import java.util.HashMap;


public class ArrayDemo {
	//given binary array (only contains 0 or 1). Find the largest subarray that
	//contain equal number of 0 and 1
	public static int solve(int[] a) {
		//consider 0 as -1. find the longest subarray that sum's elements is 0. O(NlogN)
		int n = a.length;
		for (int i = 0; i < n; i++)
			if (a[i] == 0) 
				a[i] = -1;
		int[] s = new int[n + 1];
		s[0] = 0;
		for (int i = 1;i <= n; i++)
			s[i] = s[i - 1] + a[i - 1];
		
		HashMap<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();
		int res = -1;
		int lastIndex = -1;
		mapIndex.put(s[0], 0);
		for (int i = 1; i <= n; i++)
			if (mapIndex.containsKey(s[i])) {
				int j = mapIndex.get(s[i]);
				if (s[i] == s[j] && res < i - j) {
					res = i - j;
					lastIndex = i - 1;
				}
			} else {
				mapIndex.put(s[i], i);
			}
		
		System.out.println(res);
		System.out.println(lastIndex);
		return res;
	}
//	Given an array arr[0..n-1], find the maximum j – i such that arr[j] > arr[i].
//
//	Examples:
//
//	  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
//	  Output: 6  (j = 7, i = 1)
//
//	  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
//	  Output: 8 ( j = 8, i = 0)
//
//	  Input:  {1, 2, 3, 4, 5, 6}
//	  Output: 5  (j = 5, i = 0)
//
//	  Input:  {6, 5, 4, 3, 2, 1}
//	  Output: -1 
	public static int maxIndexDiff(int[] a) {
		int res = -1;
		int n = a.length;
//		Construct LMin[] such that LMin[i] stores the minimum value
//	       from (arr[0], arr[1], ... arr[i]) */
		int[] lMin = new int[n];
		lMin[0] = a[0];
		for (int i = 1; i < n; i++)
			lMin[i] = Math.min(lMin[i - 1], a[i]);
		
		int[] rMax = new int[n];
		rMax[n - 1] = a[n - 1];
		for (int i = n - 2; i >= 0; i--)
			rMax[i] = Math.max(rMax[i + 1], a[i]);
		
		int i = 0, j = 0, maxDiff = -1;
	    while (j < n && i < n)
	    {
	        if (lMin[i] < rMax[j])
	        {
	            maxDiff = Math.max(maxDiff, j-i);
	            j = j + 1;
	        }
	        else
	            i = i + 1;
	    }
		
		return maxDiff ;
	}
//	Given a 2D array, find the maximum sum subarray in it.
	public static int getMaxMatrix(int[][] a) {
		int res = Integer.MIN_VALUE;
		int m = a.length;
		int n = a[0].length;
		
		int[][] sumCol = new int[m][n];
		for (int j = 0; j < n; j++)
			sumCol[0][j] = a[0][j];
		for (int i = 1; i < m; i++)
			for (int j = 0; j < n; j++)
				sumCol[i][j] = sumCol[i - 1][j] + a[i][j];
		
		for (int i1 = 0; i1 < m; i1++) 
			for (int i2 = i1; i2 < m; i2++) {
				//consider subarray between row i and row j
				int[] row = new int[n];
				for (int j = 0; j < n; j++) 
					if (i1 == 0)
						row[j] = sumCol[i2][j];
					else 
						row[j] = sumCol[i2][j] - sumCol[i1 - 1][j];
				int maxRow = getMaxArray(row);
				if (res < maxRow) 
					res = maxRow;
			}
		return res;
	}
	
	public static int getMaxArray(int[] a) {
		int n = a.length;
		int[] f = new int[n];
		f[0] = a[0];
		int res = f[0];
		for (int i = 1; i < n; i++) {
			f[i] = Math.max(a[i], f[i - 1] + a[i]);
			res = Math.max(res,f[i]);
		}
		return res;
	}
	
//	Given an array of integers and a number x, find the smallest subarray with sum greater 
//	than the given value.
//
//	Examples:
//	arr[] = {1, 4, 45, 6, 0, 19}
//	   x  =  51
//	Output: 3
//	Minimum length subarray is {4, 45, 6}
//
//	arr[] = {1, 10, 5, 2, 7}
//	   x  = 9
//	Output: 1
//	Minimum length subarray is {10}
//
//	arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
//	    x = 280
//	Output: 4
//	Minimum length subarray is {100, 1, 0, 200}
	public static int smallestLen(int[] a, int k) {
		int res = Integer.MAX_VALUE;
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int n = a.length;
		while (end < n) {
			//add more element till sum >= k
			while (sum <= k && end < n)  {
				sum += a[end++];
				if (sum >= k)
					res = Math.min(res, end - start);
			}
				
			
			while (start < n && sum > k) {
				sum -= a[start++];
				if (sum >= k)
					res = Math.min(res, end - start);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = {0,0,1,1,1,0,0,0,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
//		solve(a);
//		int[] a = {9,2,3,4,10,0};
//		System.out.println(maxIndexDiff(a));
//		int[][] a2 = {{1, 2, -1, -4, -20},
//                	  {-8, -3, 4, 2, 1},
//                	  {3, 8, 10, 1, 3},
//                	  {-4, -1, 1, 7, -6}
//               		};
//		System.out.println(getMaxMatrix(a2));
		
		int[] a = {7,2,1,5,6,4,3,8};
		System.out.println(smallestLen(a,15));
	}

}
