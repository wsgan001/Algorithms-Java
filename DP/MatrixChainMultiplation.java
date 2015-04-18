package DP;

import java.util.Arrays;

//Given an array p[] which represents the chain of matrices such that the ith matrix Ai 
//is of dimension p[i-1] x p[i]. We need to write a function MatrixChainOrder() that 
//should return the minimum number of multiplications needed to multiply the chain.
//
//		  Input: p[] = {40, 20, 30, 10, 30}   
//		  Output: 26000  
//		  There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
//		  Let the input 4 matrices be A, B, C and D.  The minimum number of 
//		  multiplications are obtained by putting parenthesis in following way
//		  (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
//
//		  Input: p[] = {10, 20, 30, 40, 30} 
//		  Output: 30000 
//		  There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30. 
//		  Let the input 4 matrices be A, B, C and D.  The minimum number of 
//		  multiplications are obtained by putting parenthesis in following way
//		  ((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30
//
//		  Input: p[] = {10, 20, 30}  
//		  Output: 6000  
//		  There are only two matrices of dimensions 10x20 and 20x30. So there 
//		  is only one way to multiply the matrices, cost of which is 10*20*30
public class MatrixChainMultiplation {

	public static int matrixChain(int[] p) {
		if (p.length < 3) return 0;
		int n = p.length - 1;
		int oo = 1000000000;
		
		int[][] f = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++)
			Arrays.fill(f[i], oo);

		int[][] tr = new int[n + 1][n + 1];
		
		//initialize f[i][i];
		for (int i = 1; i <= n; i++) {
			f[i][i] = 0;
			tr[i][i] = i;
		}
			
		//initialize f[i - 1][i];
		for (int i = 2; i <= n; i++) {
			f[i - 1][i] = p[i - 2] * p[i - 1] * p[i];
			tr[i - 1][i] = i - 1;
		}
			
		
		for (int len = 3; len <= n; len++)
			for (int i = 1; i <= n - len + 1; i++) {
				int j = i + len - 1;
//				System.out.println(i + " " + j);
				for (int k = i; k < j; k++)
					if (f[i][j] > f[i][k] + f[k + 1][j] + p[i-1]*p[k]*p[j]) {
						f[i][j] = f[i][k] + f[k + 1][j] + p[i-1]*p[k]*p[j];
						tr[i][j] = k;
					}
					  
			}
		run(tr, 1, n);
		System.out.println();
		return f[1][n];
	}
	
	public static void run(int[][] tr, int i, int j) {
		if (i == j) {
			System.out.print(i);
			return;
		}
		System.out.print('(');
		int k = tr[i][j];
		run(tr,i,k);
		run(tr,k+1,j);
		System.out.print(')');
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = {4,2,3,1,3};
//		int[] p = {10, 20, 30, 40, 30};
//		int[] p = {10, 20, 30};  
		System.out.println(matrixChain(p));
	}

}
