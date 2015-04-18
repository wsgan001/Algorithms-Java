package Recursion;

import java.util.ArrayList;

public class PermuationSequence {

	public static int[] getPermutation(int n, int k) {
		int[] res = new int[n];
		ArrayList<Integer> d = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++)
			d.add(i);
		int[] fac = new int[n];
		fac[0] = 1;
		for (int i = 1; i < n; i++)
			fac[i] = fac[i - 1] * i;
		if (k < 1 || k > fac[n - 1] * n)
			return null;
		for (int i = n - 1; i >= 0; i--) {
			//find the i-th element of sequence
			int j = 0;
			while (k > fac[i]) {
				j++;
				k -= fac[i];
			}
			res[n - i - 1] = d.get(j);
			d.remove(j);
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] res = getPermutation(4, 12);
		for (int i : res) 
			System.out.print(i + " ");
	}

}
