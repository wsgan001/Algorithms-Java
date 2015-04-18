package RECAP;

import java.util.ArrayList;
import java.util.Arrays;

public class PhanTichSo {

	//extract an integer n as sum of smaller integer.  3 = 1 + 2 and 3 = 2 + 1 counted as 1 way.
	public static ArrayList<int[]> extract(int n) {
		ArrayList<int[]> res = new ArrayList<int[]>();
		int[] x = new int[n + 1];
		x[0] = 1;
		run(0, n, 1, x, res);
		return res;
	}
	
	public static void run(int sum, int n, int index, int[] x, ArrayList<int[]> res) {
		if (sum < n) 
			for (int i = x[index - 1]; i + sum <= n; i++) {
				x[index] = i;
				sum += i;
				if (sum == n) {
					int[] way = new int[index];
					System.arraycopy(x, 1, way, 0, index);
					res.add(way);
				} else {
					run(sum, n, index + 1, x, res);
				}
				sum -= i;
			}
	}
	
	//extract an integer n using list of candidate
	public static ArrayList<int[]> extract(int n, int[] a) {
		ArrayList<int[]> res = new ArrayList<int[]>();
		Arrays.sort(a);
		
		int[] x = new int[n + 1];
		x[0] = a[0];
		
		run(0, n, 1, x, a, res);
		return res;
	}
	
	public static void run(int sum, int n, int index, int[] x, int[] a, ArrayList<int[]> res) {
		if (sum < n) 
			for (int i = 0; i < a.length; i++)
				if (sum + a[i] <= n && a[i] >= x[index - 1]) {
					x[index] = a[i];
					sum += a[i];
					if (sum == n) {
						int[] r = new int[index];
						System.arraycopy(x, 1, r, 0, index);
						res.add(r);
					} else {
						run(sum, n, index + 1, x, a, res);
					}
					sum -= a[i];
				}
	}
	
	public static int countChange(int m, int[] a) {
		int n = a.length;
		int[][] f = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++)
				f[i][j] = 0;
		for (int j = 0; j <= n; j++)
			f[0][j] = 1;
		
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				if (i < a[j - 1]) {
					f[i][j] = f[i][j - 1];
					continue;
				} else
					for (int k = 0; k*a[j-1] <= i; k++)
						f[i][j] += f[i - k*a[j-1]][j - 1];
			}
		return f[m][n];
	}
	
	//co n goi keo (n <= 200), moi goi chua ko qua 200 cai keo va 1 so M < 40000.
	//tim cach lay ra 1 so it nhat goi keo de dc tong so keo la M. hoac thong bao ko the
	public static int candy(int[] a, int m) {
		int n = a.length;
		int oo = 10000;
		//f[i][j] is the minimum packs from 1..j need to sum up a value of i. f[i][j] == oo if cannot choose
		int[][] f = new int[m + 1][n + 1];
		int[][] tr = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			f[i][0] = oo;
		for (int j = 0; j <= n; j++)
			f[0][j] = 0;
		
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				f[i][j] = oo;
				tr[i][j] = 0; //not choose
				if (i >= a[j-1])
					for (int k = 0; k < j; k++)
						if (f[i][j] > f[i-a[j-1]][k] + 1) {
							f[i][j] = f[i-a[j-1]][k] + 1;
							tr[i][j] = k;
						}
			}
		int res = oo;
		int last = -1;
		for (int j = 1; j <= n; j++)
			if (res > f[m][j]) {
				res = f[m][j];
				last = j;
			}

		if (res == oo)
			return -1;
		else {
			int i = m;
			int j = last;
			while (i > 0) {
				if (tr[i][j] != -1) {
					System.out.print(j - 1 + " ");
					int temp = i;
					i = i - a[j-1];
					j = tr[temp][j];
				} else {
					j--;
					continue;
				}
			}
			System.out.println();
			
		}
		return res;
	}
	
	public static int candy1(int[] a, int m) {
		int n = a.length;
		//f[i] is the minimum value j such that i can be the sum of a[1]..a[j]. because j is minimal
		//then the sum must contain a[j]
		int[] f = new int[m + 1];
		f[0] = 0;
		int oo = 10000;
		for (int i = 1; i <= m; i++) {
			f[i] = oo;
			for (int j = 1; j <= n; j++)
				if (i >= a[j - 1] && f[i-a[j-1]] < j) {
					f[i] = j;
					break;
				}
		}
		int i = m;
		int len = 0;
		while (i > 0) {
			System.out.print(a[f[i]-1] + " + ");
			i = i - a[f[i] - 1];
			len++;
		}
		System.out.println();
			
		if (f[m] > 0)
			return len;
		else
			return -1;
	}
	
	
	public static void main(String[] args) {
		int[] a = {2,4,5,1,7,3};
		int n = 92;
		ArrayList<int[]> res = extract(n, a);
//		for (int[] x : res) {
//			for (int i : x)
//				System.out.print(i + " ");
//			System.out.println();
//		}
		System.out.println(res.size());
		System.out.println(countChange(n, a));
//		int[] a = {2, 3, 1, 5 ,6};
//		int[] a = {3, 34, 4, 12, 5, 2};
		System.out.println(candy1(a, 7));
	}

}
