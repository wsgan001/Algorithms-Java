package FINAL;

import java.util.ArrayList;
import java.util.Arrays;

public class PhanTichSo {
	
	public static void run(int sum, ArrayList<Integer> x, int[] a, int m, ArrayList<ArrayList<Integer>> res) {
		if (sum > m)
			return;
		if (sum == m) {
			res.add((ArrayList<Integer>) x.clone());
			return;
		}
		int pre = 0;
		if (x.size() > 0)
			pre = x.get(x.size() - 1);
		for (int i = 0; i < a.length; i++) {
			if (sum + a[i] <= m && a[i] >= pre) {
				sum += a[i];
				x.add(a[i]);
				run(sum, x, a, m, res);
				sum -= a[i];
				x.remove(x.size() - 1);
			}
		}
	}

	public static ArrayList<ArrayList<Integer>> extract(int[] a, int m) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(a);
		int n = a.length;
		if (n == 0)
			return res;
		ArrayList<Integer> x = new ArrayList<Integer>();
		run(0, x, a, m, res);
		return res;
	}
	
	public static int countExtract(int[] a, int m) {
		int n = a.length;
		int[][] f = new int[m + 1][n + 1];
		
		for (int i = 0; i <= m; i++)
			f[i][0] = 0;
		for (int j = 0; j <= n; j++)
			f[0][j] = 1;

		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				f[i][j] = 0;
				for (int k = 0; k * a[j - 1] <= i; k++)
					f[i][j] += f[i - k*a[j-1]][j-1]; 
			}
		return f[m][n];
	}
	
	
	//consider each number in array a must in use only 1 time
	public static int candy(int[] a, int m) {
		int n = a.length;
		
		//f[i] = minimum j such that can use a[1..j] to create a sum of i
		int[] f = new int[m + 1];
		f[0] = 0;
		int oo = Integer.MAX_VALUE;
		for (int i = 1; i <= m; i++) {
			f[i] = oo;
			for (int j = 1; j <= n; j++)
				if (i >= a[j - 1] && f[i - a[j - 1]] < j) {
					f[i] = j;
					break;
				}
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (f[m] != oo) {
			int s = m;
			while (s > 0) {
				res.add(a[f[s] - 1]);
				s = s - a[f[s] - 1];
			}
			System.out.println(res);
		}
		return f[m];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,4,5,1,7,3};
		int m = 7;
		ArrayList<ArrayList<Integer>> res = extract(a, m);
//		for (ArrayList<Integer> x : res) {
//			System.out.println(x);
//		}
		System.out.println(res.size());
		System.out.println(countExtract(a, m));
		candy(a, m);
	}

}
