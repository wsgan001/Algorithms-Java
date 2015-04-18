package Recursion;

import java.util.Arrays;

//Bai toan ma di tuan
public class MaDiTuan {

	public static final int[] di = {-2,-2,-1,1,2,2,1,-1};
	public static final int[] dj = {-1,1,2,2,1,-1,-2,-2};
	public static boolean foundSolution;
	public static int[] finalResult;
	
	public static int[] getCandidate(int p, int n, boolean[] valid) {
		int[] candidates = new int[8];
		int u = p / n;
		int v = p % n;
		Arrays.fill(candidates, -1);
		for (int k = 0; k < 8; k++) {
			int du = u + di[k];
			int dv = v + dj[k];
			if (du < 0 || du >= n) continue;
			if (dv < 0 || dv >= n) continue;
			if (valid[du * n + dv])
				candidates[k] = du * n + dv;
		}
		return candidates;
	}
	
	public static void run(int p, int n, int[] x, boolean[] valid) {
		if (foundSolution) return;
		int[] candidates = getCandidate(x[p - 1], n, valid);
		for (int k = 0; k < candidates.length; k++)
			if ( !foundSolution)
			if (candidates[k] != -1) {
				x[p] = candidates[k];
				valid[candidates[k]] = false;
				if (p == n*n - 1) {
					foundSolution = true;
//					for (int i = 0; i < x.length; i++)
//						System.out.print(x[i] + " ");
					finalResult = new int[n*n];
					System.arraycopy(x, 0, finalResult, 0, n*n);
					return;
				} else {
					run(p + 1, n, x, valid);
				}
				valid[candidates[k]] = true;
			}
	}
	
	public static int[] knight(int n, int u, int v) {
		
		int[] x = new int[n * n];
		boolean[] valid = new boolean[n * n];
		foundSolution = false;
		Arrays.fill(x, 0);
		Arrays.fill(valid, true);
		x[0] = u * n + v;
		valid[u * n + v] = false;
		run(1, n, x, valid);
		if (foundSolution == false) return null;
		return finalResult;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] r = knight(n, 0, 0);
		if ( r == null) {
			System.out.println("NO SOLUTION");
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.printf("%3d",finalResult[i*n + j]);
		}
	}

}
