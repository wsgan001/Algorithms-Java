package DP;

//int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};

public class LargestSumContinuousArray {

	public static int getMaxSum(int[] a) {
		if (a == null || a.length == 0)
			return Integer.MIN_VALUE;
		if (a.length == 1) return a[0];
		int n = a.length;
		int[] f = new int[n];
		f[0] = a[0];
		int res = f[0];
		for (int i = 1; i < n; i++) {
			f[i] = Integer.MIN_VALUE;
			f[i] = Math.max(a[i], f[i - 1] + a[i]);
			res = Math.max(res, f[i]);
		}
		return res;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(getMaxSum(a));
	}

}
