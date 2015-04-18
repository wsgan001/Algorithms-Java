import java.util.ArrayList;

//For example, if the input arrays are:
//arr1[] = {1, 3, 4, 5, 7}
//arr2[] = {2, 3, 5, 6}
//Then your program should print Union as {1, 2, 3, 4, 5, 6, 7} and Intersection as {3, 5}.

public class ArrayUnion {

	public static int[] getUnion(int[] a, int[] b) {
		if (a == null || a.length == 0) 
			return b;
		if (b == null || b.length == 0) 
			return a;
		int m = a.length;
		int n = b.length;
		int i = 0;
		int j = 0;
		ArrayList<Integer> union = new ArrayList<Integer>();
		while (i < m && j < n) {
			if (a[i] == b[j]) {
				union.add(a[i]);
				i++;
				j++;
				continue;
			}
			if (a[i] < b[j]) {
				union.add(a[i++]);
				continue;
			} 
			if (a[i] > b[j]) {
				union.add(b[j++]);
				continue;
			}
		}
		while (i < m) 
			union.add(a[i++]);
		while (j < n)
			union.add(b[j++]);
		
		int[] res = new int[union.size()];
		for (i = 0; i < res.length; i++)
			res[i] = union.get(i).intValue(); 
		return res;
	}
	
	public static int[] getIntersect(int[] a, int[] b) {
		if (a == null || a.length == 0) 
			return b;
		if (b == null || b.length == 0) 
			return a;
		int m = a.length;
		int n = b.length;
		int i = 0;
		int j = 0;
		ArrayList<Integer> intersect = new ArrayList<Integer>();
		while (i < m && j < n) {
			if (a[i] == b[j]) {
				intersect.add(a[i]);
				i++;
				j++;
				continue;
			}
			if (a[i] < b[j]) {
				i++;
				continue;
			} 
			if (a[i] > b[j]) {
				j++;
				continue;
			}
		}
		
		int[] res = new int[intersect.size()];
		for (i = 0; i < res.length; i++)
			res[i] = intersect.get(i).intValue(); 
		return res;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 3, 4, 5, 7};
		int[] b = {2, 3, 5, 6};
		int[] u = getUnion(a, b);
		for (int i = 0; i < u.length; i++)
			System.out.print(u[i] + " ");
		System.out.println();
		int[] intersect = getIntersect(a, b);
		for (int i = 0; i < intersect.length; i++)
			System.out.print(intersect[i] + " ");
	}

}
