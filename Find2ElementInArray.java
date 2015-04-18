//Given a sorted array and a number x, find a pair in array whose sum is closest to x.
//
//Examples:
//
//Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
//Output: 22 and 30
//
//Input: arr[] = {1, 3, 4, 7, 10}, x = 15
//Output: 4 and 10

public class Find2ElementInArray {

	public static void solve(int[] a, int x) {
		if (a == null || a.length < 2) return;
		int n = a.length;
		int l = 0;
		int r = n - 1;
		int minDif = 10000000;
		int resLeft = -1;
		int resRight = -1;
		while (l < r) {
			if (minDif > Math.abs(a[l] + a[r] - x)) {
				minDif = Math.abs(a[l] + a[r] - x);
				resLeft = l;
				resRight = r;
				if (minDif == 0) 
					break;
			}
			if (a[l] + a[r] < x) {
				l++;
				continue;
			}
			if (a[l] + a[r] > x) {
				r--;
				continue;
			}
		}
		System.out.println(minDif);
		System.out.println(a[resLeft] + " " + a[resRight]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {10, 22, 28, 29, 30, 40};
		solve(a, 54);
	}

}
