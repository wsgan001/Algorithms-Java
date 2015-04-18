import java.util.*;

public class QuickSort {
	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();;
	}
	
	public static void quickSort(int[] a, int low, int high) {
		if (a == null || a.length == 0) 
			return;
		if (low >= high)
			return;
		
		int middle = low + (high - low) / 2;
		int pivot = a[middle];
		
		int i = low, j = high;
		while (i <= j) {
			while (a[i] < pivot) i++;
			while (a[j] > pivot) j--;
			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		
		if (low < j) quickSort(a, low, j);
		if (i < high) quickSort(a, i, high);
	}
	
	//binary search
	public static int binarySearch(int[] a, int low, int high, int key) {
		if (low <= high) {
			int mid = low + (high - low)/2;
			if (a[mid] == key) 
				return mid;
			if (key < a[mid])
				return binarySearch(a,low, mid - 1, key);
			if (key > a[mid])
				return binarySearch(a, mid + 1, high, key);
		}
		return -1;
	}
	
	//find max element in bitonic array 
	public static int findMaxBitonic(int[] a, int low, int high) {
		if (low == high) return low;
		if (low == high - 1) 
			return (a[low] < a[high] ? high : low);
		if (low < high + 1) {
			int mid = low + (high - low)/2;
			if (a[mid] >= a[mid - 1] && a[mid] >= a[mid + 1])
				return mid;
			if (a[mid] > a[mid - 1])
				return findMaxBitonic(a,mid + 1,high);
			else
				return findMaxBitonic(a,low, mid - 1);
		}
		return -1;
	}
	
	//binary search for BITONIC ARRAY that first increase and the decrease
	public static int binarySearchBitonic(int[] a, int key) {
		//ALGO: find the maximum elemnent first, the do the binary sort in both part.
		int maxIndex = findMaxBitonic(a, 0, a.length - 1);
		System.out.println("max Index " + maxIndex);
		int res = binarySearch(a, 0, maxIndex, key);
		if (res != -1) 
			return res;
		else {
			int[] b = new int[a.length - maxIndex];
			System.arraycopy(a, maxIndex, b, 0, b.length);
			//reverse b
			int i = 0;
			int j = b.length - 1;
			while (i < j) {
				int temp = b[i]; b[i] = b[j]; b[j] = temp;
				i++;
				j--;
			}
//			print(b);
			int posInB = binarySearch(b, 0, b.length - 1, key);
//			System.out.println(posInB);
			if (posInB !=  -1)
				return b.length - 1 - posInB + maxIndex;
		}
		return -1;	
	}
	
	
	//find max element in bitonic array 
	public static int findMaxRotated(int[] a, int low, int high) {
		if (low == high) return low;
		if (low == high - 1) 
			return (a[low] < a[high] ? high : low);
		if (low < high + 1) {
			int mid = low + (high - low)/2;
			if (a[mid] >= a[mid - 1] && a[mid] >= a[mid + 1])
				return mid;
			if (a[mid] > a[low])
				return findMaxRotated(a, mid, high);
			else
				return findMaxRotated(a,low, mid - 1);
		}
		return -1;
	}
	
	
	//binary search for ROTATED ARRAY that sorted and rotated
	public static int binarySearchRotated(int[] a, int key) {
		//ALGO: find the maximum elemnent first, the do the binary sort in both part.
		int maxIndex = findMaxRotated(a, 0, a.length - 1);
		System.out.println("max Index " + maxIndex);
		int res = binarySearch(a, 0, maxIndex, key);
		if (res != -1) 
			return res;
		else {
			return binarySearch(a, maxIndex + 1, a.length - 1, key);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = {3,1,5,3,6,2,9};
//		int[] a = {3,3,3,3,3,3,3,3,3,3,3};
		
//		quickSort(a,0,a.length - 1);
//		int[] a = {1, 3, 4, 5, 6, 8, 9, 14, 11, 7, 2};
		int[] a = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
//		int[] a = {1,9,8};
		System.out.println(binarySearchBitonic(a, 5));
		
//		int[] a = {4,5,7,9,10,1,2,3}; 
//		System.out.println(binarySearchRotated(a, -4));
	
	}

}
