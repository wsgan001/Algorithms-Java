//Given a sorted array, remove the duplicates in place such that 
//each element appear only once and return the new length. 
//Do not allocate extra space for another array, you must do this in place with constant memory.
//
//For example, given input array A = [1,1,2], your function 
//should return length = 2, and A is now [1,2].


public class DuplicateArray {

	public static int[] removeDuplicate(int[] a) {
		if (a.length < 2)
			return a;
		
		int index = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] == a[i - 1]) continue;
			a[index++] = a[i];
		}
		int[] b = new int[index];
		System.arraycopy(a, 0, b, 0, index);
		return b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1,1,2,2,2,3,5,5,6,9,11};
//		int[] a = {1};
		int[] b = removeDuplicate(a);
		for (int i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");
	}

}
