package Recursion;
//liet ke to hop chap k cua n C(k,n)
import java.util.ArrayList;

public class Ckn {
	
	static int n;
	static int k;
	static int[] x = new int[k];
	static ArrayList<int[]> re = new ArrayList<int[]>();
	
	public static void update(int[] x) {
//		for (int i = 1; i < x.length; i++) 
//			System.out.print(x[i] + " ");
//		System.out.println();
		int[] a = new int[k];
		System.arraycopy(x, 1, a, 0, k);
		re.add(a);
	}
	
	public static void run(int i) {
		for (int j = x[i - 1] + 1; j <= n - k + i; j++) {
			x[i] = j;
			if (i == k) update(x);
			else run(i + 1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n = 5;
		k = 3;
		x = new int[k + 1];
		x[0] = 0;
		run(1);
//		for (int[] a:re) {
//			for (int i = 0; i < a.length; i++)
//				System.out.print(a[i]+ " ");
//			System.out.println();
//		}
		for (int i = 0; i < re.size(); i++) {
			int[] a = re.get(i);
			for (int j = 0; j < a.length; j++)
				System.out.print(a[j] + " ");
			System.out.println();
		}
	}

}
