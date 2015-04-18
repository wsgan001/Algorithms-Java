package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS {

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
//day con don dieu tang dai nhat	
	
	public static int[] longestSubArr(int[] a) {
		if (a == null) return null;
		int n = a.length;
		int[] f = new int[n];
		int[] trace = new int[n];
		
		int result = 1;
		int last = 0;
		
		Arrays.fill(f, 0);
		Arrays.fill(trace, 0);
		f[0] = 1;
		
		//dem so luong day con tang dai nhat
		int[] c = new int[n];
		Arrays.fill(c,0);
		c[0] = 1;
		
		for (int i = 1; i < n; i++) {
			f[i] = 1;
			trace[i] = i;
			for (int j = 0; j < i; j++)
				if (a[j] < a[i]) {
					if (f[i] < f[j] + 1) {
						f[i] = f[j] + 1;
						
						trace[i] = j;
						if (result < f[i]) {
							result = f[i];
							last = i;
						}
					}
				}
			c[i] = 0;
			for (int j = 0; j < i; j++)
				if (a[j] < a[i] && f[i] == f[j] + 1) 
					c[i]++;
		}

		print(c);
		System.out.println(c[last]);
		int total = 0;
		for (int i = 0; i < n; i++)
			if (f[i] == result) {
				//for each end element of lis
				int j = i;
				int s = 1;
				while (j != trace[j]) {
					s *= c[j];
					j = trace[j];
				}
				total += s;
			}
		System.out.println("total = " + total);
		//tracing
		int[] sub = new int[result];
		int i = last;
		int index = result;
		while (i != trace[i]) {
			sub[--index] = a[i];
			i = trace[i];
		}
		sub[0] = a[i];
		return sub;
	}
	
	
	public static ArrayList<int[]> lis(int[] a) {
		if (a == null) return null;
		int n = a.length;
		int[] f = new int[n];
		int m = 0;
		int lastIndex = 0;
		for (int i = 0; i < n; i++) {
			f[i] = 1;
			for (int j = 0; j < i; j++)
				if (a[j] < a[i] && f[i] < f[j] + 1) {
					f[i] = f[j] + 1;
					if (m < f[i]) {
						m = f[i];
						lastIndex = i;
					}
				}
		}
		System.out.println("Original array");
		print(a);
		System.out.println("DP array");
		print(f);
		return backTracking(a, f, m, lastIndex);
	}
	
	public static void run(int[] x, int[] a, int[] f, int i, int pos, ArrayList<int[]> re) {
		//need to find x[i]
		
		for (int j = pos - 1; j >= 0; j--)
			if (f[j] == f[pos] - 1 && a[j] < a[pos]) {
				x[i] = j;
				if (i == 0) {
					int[] xClone = x.clone();
					re.add(xClone);
				} else {
					run(x, a, f, i - 1, j, re);
				}
			}
	}
	
	public static ArrayList<int[]> backTracking(int[] a, int[] f, int m, int last) {
		ArrayList<int[]> re = new ArrayList<int[]>();
		if (m <= 1) {
			int[] x = new int[1];
			x[0] = 0;
			re.add(x);
			return re;
		}
		int[] x = new int[m];
		for (int pos = f.length - 1; pos >= 0; pos--)
			if (f[pos] == m) {
				Arrays.fill(x, 0);
				int i = m - 1;
				x[i] = pos;
				run(x, a, f, i - 1, pos, re);
			}
		return re;
	}
	
	
	//O(NlogN) algorithm to get the length of lis
	public static int getLISLength(int[] a) {
		int n = a.length;
		int[] tail = new int[n];
		int len = 1;
		tail[0] = a[0];
		for (int i = 1; i < n; i++) 
			if (a[i] < tail[0])
				tail[0] = a[i];
			else if (a[i] > tail[len - 1]) 
				tail[len++] = a[i];
			else
				tail[ceilIndex(tail, -1, len - 1, a[i])] = a[i];
				
		return len;
	}
	
	public static int ceilIndex(int[] a, int l, int r, int key) {
		
		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (a[m] >= key) 
				r = m;
			else l = m;
		}
		return r;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,7,2,3,4,8,2};
//		int[] a = {1,3,2,4,5,7,6};
//		int[] a = {1,3,2,7,6};
//		int[] a = {5,4,2};
//		int[] a = {1, 3, 2, 2, 4};
//		int[] a = {16, 5, 8, 6, 1, 10, 5, 2, 15, 3, 2, 4, 1};
		ArrayList<int[]> re = lis(a);
		System.out.println("Number of LIS " + re.size());
		for (int[] x : re) {
			for (int i = 0; i < x.length; i++)
				System.out.print(a[x[i]] + " ");
			System.out.println();
		}
		System.out.println("Length of LIS " + getLISLength(a));
	}

}
