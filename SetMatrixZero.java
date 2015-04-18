import java.util.Arrays;

//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

public class SetMatrixZero {

	public static void setZero(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		int[] row = new int[m];
		int[] col = new int[n];
		Arrays.fill(row, 0);
		Arrays.fill(col, 0);
		//marking
		for (int i = 0; i < m; i++) 
			for (int j = 0; j < n; j++)
				if (a[i][j] == 0) {
					row[i] = 1;
					col[j] = 1;
				}
		
		//assigning
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (row[i] == 1 || col[j] == 1)
					a[i][j] = 0;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {
				{1,1,1,0},
				{1,1,1,1},
				{1,0,1,1},
				{0,1,1,1}
		};
		
		setZero(a);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

}
