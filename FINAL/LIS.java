package FINAL;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS {

	public static int lis(int[] a) {
		if (a == null || a.length == 0)
			return -1;
		int n = a.length;
		int[] f = new int[n];
		int[] tr = new int[n];
		Arrays.fill(f, 1);
		
		int maxLen = 1;
		int lastIndex = 1;
		for (int i = 1; i < n; i++) {
			f[i] = 1;
			tr[i] = i;
			for (int j = 0; j < i; j++)
				if (a[j] < a[i] && f[i] < f[j] + 1) {
					f[i] = f[j] + 1;
					tr[i] = j;
					if (maxLen < f[i]) {
						maxLen = f[i];
						lastIndex = i;
					}
				}
		}
		
		int i = lastIndex;
		int[] res = new int[maxLen];
		for (int p = maxLen - 1; p >= 0; p--) {
			res[p] = a[i];
			i = tr[i];
		}
		System.out.println(Arrays.toString(res));	
		return maxLen;
	}
	
	public static ArrayList<int[]> getAllLIS(int[] a) {
		ArrayList<int[]> res = new ArrayList<int[]>();
		
		if (a == null || a.length == 0) 
			return res;
		
		int n = a.length;
		int[] f = new int[n];
		f[0] = 1;
		int maxLen = 1;
		for (int i = 1; i < n; i++) {
			f[i] = 1;
			for (int j = 0; j < i; j++)
				if (a[j] < a[i] && f[i] < f[j] + 1) {
					f[i] = f[j] + 1;
					maxLen = Math.max(maxLen, f[i]);
				}
		}
		
		int[] x = new int[maxLen];
		
		for (int i = 0; i < n; i++)
			if (f[i] == 1) {
				x[0] = i;
				run(1, x, a, f, res);
			}
		
		return res;
	}
	
	public static void run(int i, int[] x, int[] a, int[] f, ArrayList<int[]> res) {
		if (i == x.length) {
			res.add(x.clone());
			return;
		}
		for (int j = x[i - 1] + 1; j < a.length; j++)
			if (f[j] == f[x[i - 1]] + 1 && a[x[i - 1]] < a[j]) {
				x[i] = j;
				run(i + 1, x, a, f, res);
			}
	}
	
	public static int[] getLISFast(int[] a) {
		
		int n = a.length;
		int[] tail = new int[n];
		tail[0] = a[0];
		int len = 1;
		for (int i = 1; i < n; i++) {
			if (a[i] < tail[0]) {
				tail[0] = a[i]; 	//create a new activity-array
				continue;
			}
			if (a[i] > tail[len - 1]) {
				tail[len++] = a[i];
				continue;
			}
			int ceil = findCeil(tail, 0, len - 1, a[i]);
			tail[ceil] = a[i];
		}
		int[] res = new int[len];
		System.arraycopy(tail, 0, res, 0, len);
		return res;
	}
	
	public static int findCeil(int[] a, int low, int high, int key) {
		if (a[low] > key)
			return low;
		
		if (a[high] < key)
			return high + 1;
		
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid == 0)
				return a[low] < key ? low : low + 1;
			if (a[mid] > key && a[mid - 1] < key)
				return mid;
			if (a[mid] > key)
				return findCeil(a, low, mid - 1, key);
			else
				return findCeil(a, mid + 1, high, key);
		}
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,4,3,6,5,7};
		System.out.println(lis(a));
		ArrayList<int[]> res = getAllLIS(a);
		for (int[] x : res) {
			for (int i = 0; i < x.length; i++)
				System.out.print(a[x[i]] + " ");
			System.out.println();
		}
		
		int[] fast = getLISFast(a);
		System.out.println(Arrays.toString(fast));
	}

}
