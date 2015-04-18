import java.util.Scanner;

public class SpiralMatrix {

	public static int[] getSpiral(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		
		if (m*n == 0) return null;
		
		int[] result = new int[m*n];
		int[][] b = new int[m + 2][n + 2];
		boolean[][] v = new boolean[m + 2][n + 2];
		
		for (int i = 0; i <= m + 1; i++)
			for (int j = 0; j <= n + 1; j++) {
				v[i][j] = false;
			}
		
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				v[i][j] = true;
				b[i][j] = a[i - 1][j - 1];
			}
		
		int k = 1;
		int i = 1;
		int j = 1;
		result[0] = b[i][j];
		v[1][1] = false;
		while (k < m*n) {
			while (v[i][j + 1] == true) {
				result[k] = b[i][j+1];
				v[i][j+1] = false;
				j++;
				k++;
			}
			while (v[i+1][j] == true) {
				result[k] = b[i+1][j];
				v[i+1][j] = false;
				i++;
				k++;
			}
			while (v[i][j - 1] == true) {
				result[k] = b[i][j-1];
				v[i][j-1] = false;
				j--;
				k++;
			}
			while (v[i-1][j] == true) {
				result[k] = b[i-1][j];
				v[i-1][j] = false;
				i--;
				k++;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] a = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = in.nextInt();
		int[] result = new int[m*n];
		result = getSpiral(a);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

}

//3 3
//1 2 3
//4 5 6
//7 8 9

