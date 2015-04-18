package RECAP;
//Input: p[] = {40, 20, 30, 10, 30}   
//Output: 26000  
public class MatrixChain {
	
	public static int matrixChain(int[] a) {
		int n = a.length - 1;
		//cost for multiple matrix i..j
		int[][] f = new int[n + 1][n + 1];
		int oo = 1000000000;
		for (int i = 0; i <= n; i++)
			f[i][i] = 0;
		
		int[][] tr = new int[n + 1][n + 1];
		//initialization for case len = 2;
		for (int i = 1; i < n; i++) {
			f[i][i + 1] = a[i-1]*a[i]*a[i+1];
			tr[i][i + 1] = i;
		}
			
		
		//processing
		for (int len = 3; len <= n; len++)
			for (int i = 1; i <= n - len + 1; i++) {
				int j = i + len - 1;
				f[i][j] = oo;
				tr[i][j] = -1;
				for (int k = i; k < j; k++)
					if (f[i][j] > f[i][k] + f[k+1][j] + a[i-1] * a[k] * a[j]) {
						f[i][j] = f[i][k] + f[k+1][j] + a[i-1] * a[k] * a[j];
						tr[i][j] = k;
					}
						
			}
		
		int i = 1;
		int j = n;
		run(1, n, tr);
		System.out.println();
		return f[1][n];
	}
	
	public static void run(int i, int j, int[][] tr) {
		if (i > j) 
			return;
		if (i == j) {
			System.out.print("a["+ i + "]");
			return;
		}
		int k = tr[i][j];
		System.out.print("(");
		run(i, k, tr);
		run(k + 1, j, tr);
		System.out.print(")");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,2,3,1,3};
//		int[] a = {10, 20, 30, 40, 30};

		System.out.println(matrixChain(a));
	}

}
