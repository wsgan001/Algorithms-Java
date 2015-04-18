//he maximum subarray problem is the task of finding the contiguous subarray within 
//a one-dimensional array of numbers (containing at least one positive number) which 
//has the largest sum. For example, for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; 
//the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.

public class Kadane {

	
	//if allow subarray has length of 0
	public static int kadane0(int[] a) {
		if (a == null || a.length == 0) 
			return 0;
		int n = a.length;
		int res = Integer.MIN_VALUE;
		int[] f = new int[n];
		f[0] = 0;
		for (int i = 1; i < n; i++) {
			f[i] = Math.max(0, f[i - 1] + a[i]);
			res = Math.max(res, f[i]);
		}
		return res;
	}
	
	//if NOT allow subarray has length of 0
	public static int kadane1(int[] a) {
		if (a == null || a.length == 0) 
			return 0;
		int n = a.length;
		int res = Integer.MIN_VALUE;
		int[] f = new int[n];
		f[0] = a[0];
		for (int i = 1; i < n; i++) {
			f[i] = Math.max(a[i], f[i - 1] + a[i]);
			res = Math.max(res, f[i]);
		}
		return res;
	}
	
	//for circular array
	public static int kadaneCircular(int[] a) {
		int n = a.length;
		int res = Integer.MIN_VALUE;
		
		//consider case subarray is not wrapped
		int k1 = kadane1(a); 
		
		//consider case subarray is wrapped, we inverse the sign of a[i]
		int sum = 0;
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			sum += a[i];
			b[i] = - a[i];
		}
		int k2 = kadane1(b);
		k2 = sum + k2;  //actually k2 = sum - (-k2)
		
		res = Math.max(k1, k2);
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = {-10,-2,-3,-4};
//		int[] a = {-1,2,4,-3,-5,2};
		int[] a = {2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(kadane0(a));
		System.out.println(kadane1(a));
		System.out.println(kadaneCircular(a));
	}

}
