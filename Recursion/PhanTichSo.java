package Recursion;

import java.util.ArrayList;

//express int n as sum of some integer (n <= 30)
public class PhanTichSo {

	public static void run(int i, int n, int[] x, int sum, ArrayList<int[]> re) {
		if (i <= n)
		for (int j = x[i - 1]; j <= n; j++)
			if (sum + j <= n) {
				x[i] = j;
				sum = sum + j;
				if (sum == n) {
					int[] a = new int[i];
					System.arraycopy(x, 1, a, 0, i);
					re.add(a);
				} else {
					run(i + 1, n, x, sum, re);
				}
				sum = sum - j;
			}
	}
	
	public static ArrayList<int[]> extract(int n) {
		ArrayList<int[]> re = new ArrayList<int[]>();
		if (n == 0) return re;
		int sum = 0;
		int[] x = new int[n + 1];
		x[0] = 1;
		run(1, n, x, sum, re);
		return re;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<int[]> r = extract(5);
		for (int[] x : r) {
			for (int i = 0; i < x.length; i++) 
				System.out.print(x[i] + " ");
			System.out.println();
		}
		System.out.println(r.size());
	}

}
