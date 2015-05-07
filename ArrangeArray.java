//Given an array of numbers, arrange them in a way that yields the largest value. 
//For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 
//gives the largest value. And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, 
//then the arrangement 998764543431 gives the largest value

public class ArrangeArray {

	public static String arrangeArray(int[] a) {
		String res = "";
		if (a == null || a.length == 0) 
			return res;
		int n = a.length;
		String[] s = new String[n];
		for (int i = 0; i < n; i++)
			s[i] = String.valueOf(a[i]);
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (myCompare(s[i], s[j]) < 0) {
					String temp = s[i]; s[i] = s[j]; s[j] = temp;
				}
		for (int i = 0; i < n; i++)
			res = res + s[i];
		return res;
	}
	
	public static int myCompare(String x, String y) {
		String xy = x + y;
		String yx = y + x;
		
		return xy.compareTo(yx);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {54, 546, 548, 60};
//		int[] a = {1, 34, 3, 98, 9, 76, 45, 4};
		System.out.println(arrangeArray(a));
	}

}
