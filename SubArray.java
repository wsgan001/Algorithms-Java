//Find the contiguous subarray within an array 
//(containing at least one number) which has the largest sum.
//For example, given the array [−2,1,−3,4,−1,2,1,−5,4], 
//the contiguous subarray [4,−1,2,1] has the largest sum = 6.

public class SubArray {

	public static int solve(int[] a) {
		int n = a.length;
		if (n == 0)
			return Integer.MIN_VALUE;
		
		int[] f = new int[n];
		f[0] = Math.max(0, a[0]);
		int maxEle = a[0];
		int result = Integer.MIN_VALUE;
		
		for (int i = 1; i < n; i++) {
			if (a[i] >= 0) {
				f[i] = f[i - 1] + a[i];
				maxEle = Math.max(maxEle, a[i]);
			} else {
				f[i] = Math.max(0, f[i - 1] + a[i]);
				maxEle = Math.max(maxEle, a[i]);
			}
			result = Math.max(result, f[i]);
		}
		if (maxEle < 0) 
			return maxEle;
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println(solve(a));
	}

}
