package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

//sinh day nhi phan do dai n
public class nBit {
	
	public static int n;
	public static int[] x;
	
	
	public static void printResult(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i]);
		}
		System.out.println();
	}
	
	public static void run(int k) {
		if (k > n-1) {
			printResult(x);
			return;
		}
		if (k < n)
		for (int i = 0; i <= 1; i++) {
			x[k] = i;
			run(k + 1);
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n = 4;
		x = new int[n];
		Arrays.fill(x, 0);
		run(0);
	}

}
