//Write an efficient algorithm that searches for a value in an m x n matrix. 
//This matrix has properties:
//1) Integers in each row are sorted from left to right. 
//2) The first integer of each row is greater than the last integer of the previous row.

public class Search2DMatrix {

	public static boolean search2D(int[][] a, int target) {
		int m = a.length;
		if (m == 0) 
			return false;
		int n = a[0].length;
		if (n == 0)
			return false;
		
		int begin = 0;
		int end = m*n - 1;
		
		while (begin <= end) {
			int mid = (begin + end) / 2;
			int row = mid / n;
			int col = mid % n;
			if (a[row][col] == target) {
				return true;
			}
			if (a[row][col] < target) {
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {
				{1,3,5,7},
				{10,11,16,20},
				{23,30,34,50}
		};
		
		System.out.println(search2D(a, 16));
	}

}
