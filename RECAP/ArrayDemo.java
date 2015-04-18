package RECAP;

import java.util.PriorityQueue;

public class ArrayDemo {
	
	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}
	//QuickSort
	public static void quickSort(int[] a, int low, int high) {
		if (low >= high)
			return;
		int mid = low + (high - low) / 2;
		int pivot = a[mid];
		int i = low, j = high;
		while (i <= j) {
			while (a[i] < pivot) i++;
			while (a[j] > pivot) j--;
			if (i <= j) {
				int temp = a[i]; a[i] = a[j]; a[j] = temp;
				i++;
				j--;
			}
		}
		quickSort(a, low, j);
		quickSort(a, i, high);
	}
	
	
	//Find median of two sorted array
	public static int getMedian(int[] a, int[] b, int startA, int endA, int startB, int endB) {
		int lenA = endA - startA + 1;
		int lenB = endB - startB + 1;
		//assume that lenA = lenB
		if (lenA == 0) 
			return -1;
		
		if (lenA == 1) 
			return (a[startA] + b[startB]) / 2;
		
		if (lenA == 2) 
			return (Math.max(a[startA], b[startB]) + Math.min(a[startA+1], b[startB+1]))/2;
		
		int m1 = median(a, startA, endA);
		int m2 = median(b, startB, endB);
		
		
		int midA = startA + lenA/2;
		int midB = startB + lenB/2;
		
		if (m1 == m2)
			return m1;
		if (m1 < m2)
			return getMedian(a, b, midA, endA, startB, midB);
		if (m1 > m2)
			return getMedian(a, b, startA, midA, midB, endB);
		
		return 0;
	}
	
	public static int median(int[] a, int start, int end) {
		int len = end - start + 1;
		if (len < 1) 
			return -1;
		
		if (len == 1)
			return a[start];
		
		if (len % 2 == 1)
			return a[start + len/2];
		else 
			return (a[start + len/2] + a[start + len/2 - 1]) / 2;
	}
	
	
	//Kadane Algorith: given array contains - or + int. Find subarray with largest sum
	//If allow 0 element
	public static int kadane0(int[] a) {
		int n = a.length;
		int[] f = new int[n];
		f[0] = Math.max(0, a[0]);
		int res = f[0];
		for (int i = 1; i < n; i++) {
			f[i] = Math.max(0, f[i - 1] + a[i]);
			res = Math.max(res, f[i]);
		}
			
		return res;
	}
	
	//If sub array must have at least 1 element
	public static int kadane1(int[] a) {
		int n = a.length;
		int[] f = new int[n];
		f[0] = a[0];
		int res = f[0];
		for (int i = 1; i < n; i++) {
			f[i] = Math.max(a[i], f[i - 1] + a[i]);
			res = Math.max(res, f[i]);
		}
		return res;
	}
	
	
	//remove duplicated elements from array
	public static int[] removeDup(int[] a) {
		int index = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] == a[i - 1])
				continue;
			a[index++] = a[i];
		}
		int[] b = new int[index];
		System.arraycopy(a, 0, b, 0, index);
		return b;
	}
	
	
	//rotate a square matrix in-place
	public static void rotate(int[][] a) {
		int n = a.length;
		for (int i = 0; i <= n / 2; i++) {
			int first = i;
			int last = n - i - 1;
			for (int j = first; j < last; j++) {
				int top = a[i][j];
				a[i][j] = a[j][n-i-1];
				a[j][n-i-1] = a[n-i-1][n-j-1];
				a[n-i-1][n-j-1] = a[n-j-1][i];
				a[n-j-1][i] = top;
			}
		}
		print(a);
	}
	
	//Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7
	//3,5,7,9,15,21,25,27,35,45,49
	public static int magicNumber(int n) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(1);
		for (int i = 0; i < n; i++) {
			int val = queue.poll();
			if (!queue.contains(val * 3))
				queue.add(val * 3);
			if (!queue.contains(val * 5))
				queue.add(val * 5);
			if (!queue.contains(val * 7))
				queue.add(val * 7);
		}
		return queue.poll();
	}
	
	//find position to insert new element in sorted array
	public static int findInsertPos(int[] a, int low, int high, int key) {
		if (key <= a[low])
			return low;
		if (key >= a[high])
			return high + 1;
		if (low >= high)
			return low;
		int mid = low + (high - low) / 2;
		if (mid == 0) {
			return a[0] > key ? 0 : 1;
		} else {
			if (a[mid - 1] < key && key <= a[mid])
				return mid;
			if (a[mid] < key)
				return findInsertPos(a, mid + 1, high, key);
			if (a[mid] >= key) 
				return findInsertPos(a, low, mid - 1, key);
		}
		return 0;	
	}
	
	
	public static void main(String[] args) {
//		int[] a = {1, 12, 15, 26, 38};
//		int[] b = {2, 13, 17, 30, 45};
//		int[] a = {1, 2, 3, 6};
//		int[] b = {4, 6, 8, 10};
//		System.out.println(getMedian(a, b, 0, a.length - 1, 0, b.length - 1));
//		--------------------------------------------------------------------------
//		int[] a = {2,3,4,5,2,3,4,5,7,4,7};
//		quickSort(a, 0, a.length - 1);
//		print(a);
//		--------------------------------------------------------------------------
		int[] a = {1,-3};
		System.out.println(kadane0(a));
//		--------------------------------------------------------------------------
//		int[] a = {1,2,2,2,3,5,5,6,9,11};
//		int[] b = removeDup(a);
//		print(b);
//		--------------------------------------------------------------------------
//		int[][] a = {
//				{1,2,3,4},
//				{5,6,7,8},
//				{9,10,11,12},
//				{13,14,15,16},
//		};
//		int[][] a = {
//				{1,1,1,1,1},
//				{2,2,2,2,2},
//				{1,1,1,1,1},
//				{3,3,3,3,3},
//				{9,9,9,9,9}
//		};
//		rotate(a);
		
		
//		int[] a = {1, 2, 4, 7};
//		int key = 111;
//		System.out.println(findInsertPos(a, 0, a.length - 1, key));
	}
}
