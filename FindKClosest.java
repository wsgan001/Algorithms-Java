import java.util.Arrays;


//Given a sorted array arr[] and a value X, find the k closest elements to X in arr[]. 
//Examples:
//
//Input: K = 4, X = 35
//       arr[] = {12, 16, 22, 30, 35, 39, 42, 
//               45, 48, 50, 53, 55, 56}
//Output: 30 39 42 45


public class FindKClosest {


	public static int findElement(int[] a, int low, int high, int x) {
		if (x < a[low]) 
			return low;
		if (a[high] < x) 
			return high;
		int mid = low + (high - low) / 2;
		if (a[mid] <= x && a[mid + 1] > x) return mid;
		if (a[mid] < x) 
			return findElement(a, mid + 1, high, x);
		else 
			return findElement(a, low, mid - 1, x);
	}
	
	public static int[] findKClosest(int[] a, int k, int x) {
		int n = a.length;
		if (n < k) 
			return null;
		
		int[] res = new int[k];
		
		//find the first index that > x
		int index = findElement(a,0,a.length - 1,x);
		int left = index;
		int right = index + 1;
		for (int i = 0; i < k; i++) {
			if (left < 0) {
				res[i] = a[right++];
				continue;
			}
			if (right > a.length - 1) {
				res[i] = a[left--];
				continue;
			}
			if (Math.abs(x - a[left]) < Math.abs(a[right] - x))
				res[i] = a[left--];
			else
				res[i] = a[right++];
		}
		Arrays.sort(res);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {12,16,29,30,35,39,44,45,48,50,53,56};
		int[] res = findKClosest(a, 4, 35);
		for (int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");
	}

}
