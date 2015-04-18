
public class CountInversion {
	//given array a[0..n-1]. Counting the number of pair (i,j) such that i < j and a[i] > a[j]
	public static int countInversionNative(int[] a) {
		int n = a.length;
		int res = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (a[i] > a[j]) 
					res++;
		return res;
	}
	
	public static int countInversion(int[] a) {
		return mergeSort(a, 0, a.length - 1);
	}
	
	public static int mergeSort(int[] a, int low, int high) {
		if (low >= high) 
			return 0;
		int mid = low + (high - low) / 2;
		return mergeSort(a, low, mid) + mergeSort(a, mid + 1, high) + merge(a, low, mid, high);
	}
	
	public static int merge(int[] a, int low, int mid, int high) {
		int count = 0;
		int n = a.length;
		int[] temp = new int[n];
		int i = low;
		int j = mid + 1;
		int k = low;
		while (i <= mid - 1 && j <= high) {
			if (a[i] <= a[j])
				temp[k++] = a[i++];
			else {
				temp[k++] = a[j++];
				count += mid - i + 1;
			}
		}
		while (i <= mid - 1)
			temp[k++] = a[i++];
		while (j <= high)
			temp[k++] = a[j++];
		
		for (i=low; i <= high; i++)
		    a[i] = temp[i];
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,4,2,5,3};
		System.out.println(countInversionNative(a));
		System.out.println(countInversion(a));
	}

}
