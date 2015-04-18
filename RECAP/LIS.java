package RECAP;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS {

	public static int getLIS(int[] a) {
		int n = a.length;
		if (n < 2)
			return n;
		int maxLen = 0;
		int[] f = new int[n];
		f[0] = 1;
		for (int i = 1; i < n; i++) {
			f[i] = 1;
			for (int j = 0; j < i; j++)
				if (a[j] < a[i] && f[i] < f[j] + 1) {
					f[i] = f[j] + 1;
					maxLen = Math.max(maxLen, f[i]);
				}
		}
		return maxLen;
	}
	
	public static ArrayList<int[]> getAllLIS(int[] a) {
		int n = a.length;
		ArrayList<int[]> res = new ArrayList<int[]>();
		if (n == 0) 
			return res;
		
		int[] f = new int[n];
		f[0] = 1;
		int maxLen = 0;
		for (int i = 1; i < n; i++) {
			f[i] = 1;
			for (int j = 0; j < i; j++)
				if (a[j] < a[i] && f[i] < f[j] + 1) {
					f[i] = f[j] + 1;
					maxLen = Math.max(maxLen, f[i]);
				}
		}
		System.out.println(maxLen);
		res = tracing(a, f, maxLen);
		return res;
	}
	
	public static ArrayList<int[]> tracing(int[] a, int[] f, int maxLen) {
		ArrayList<int[]> res = new ArrayList<int[]>();
		int[] x = new int[maxLen];
		for (int i = 0; i < a.length; i++)
			if (f[i] == 1) {
				Arrays.fill(x, 0);
				x[0] = i;
				run(1, x, a, f, maxLen, res);
			}
		return res;		
	}
	
	public static void run(int i, int[] x, int[] a, int[] f, int maxLen, ArrayList<int[]> res) {
		if (i == maxLen) {
			res.add(x.clone());
			return;
		}
		for (int j = x[i-1] + 1; j < a.length; j++)
			if (a[x[i-1]] < a[j] && f[x[i-1]] + 1 == f[j]) {
				x[i] = j;
				run(i + 1, x, a, f, maxLen, res);
			}
				
	}
	
	//LIS with O(NlogN) algorithm. NOTE: ONLY WORK FOR ARRAY WITH NO DUPLICATED ELEMENTS
	public static int[] getLISFast(int[] a) {
		int n = a.length;
		if (n < 2)
			return a;
		int[] tail = new int[n];
		int len = 1;
		tail[0] = a[0];
		for (int i = 1; i < n; i++) {
			//case 1 : a[i] > max value of all activity array
			if (a[i] > tail[len - 1]) {
				tail[len++] = a[i];
				continue;
			}
			//case 2 : a[i] < first value of activity arrays
			if (a[i] < tail[0]) {
				tail[0] = a[i];	//create new activity array
				continue;
			}
			//case 3 : find the suiable activity array, update and remove the others that has same size
			tail[ceilIndex(tail, 0, len - 1, a[i])] = a[i];
		}
		int[] b = new int[len];
		System.arraycopy(tail, 0, b, 0, len);
		return b;
	}
	
	public static int ceilIndex(int[] a, int l, int r, int key) {
		while (l + 1 < r) {
			int mid = l + (r - l) / 2;
			if (a[mid] > key && a[mid - 1] < key)
				return mid;
			if (a[mid] < key)
				l = mid + 1;
			else 
				r = mid - 1;
		}
		return r;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = {1,3,2,4,7,6,5,9};
		int[] a = {1,3,7,2,3,4,8,2};
//		System.out.println(getLIS(a));
//		ArrayList<int[]> res = getAllLIS(a);
//		for (int[] x : res) {
//			for (int i : x)
//				System.out.print(a[i] + " ");
//			System.out.println();
//		}
		
		int[] lis = getLISFast(a);
		for (int i : lis)
			System.out.print(i + " ");
		System.out.println();
	}

}
