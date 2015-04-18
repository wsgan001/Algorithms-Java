package RECAP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingDemo {

	public static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++)
			for (int j = i + 1; j < a.length; j++)
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
		
	}
	
	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " " );
		System.out.println();
	}
	
	public static void quickSort(int[] a, int low, int high) {
		if (low > high) 
			return;
		int pivot = a[low + (high - low) / 2];
		int i = low;
		int j = high;
		while (i <= j) {
			while (a[i] < pivot) i++;
			while (a[j] > pivot) j--;
			if (i <= j) {
				int temp = a[i]; a[i] = a[j]; a[j] = temp;
				i++;
				j--;
			}
		}
		quickSort(a, low, j);
		quickSort(a, i, high);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 1000000;
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = (int) (Math.random() * 1000);
		
		
		//BUBBLE SORT
//		long startTime = System.currentTimeMillis();
//		bubbleSort(a);
//		long endTime = System.currentTimeMillis();
//		System.out.printf("%.3f \n",(endTime - startTime) / 1000.0);
		
//		long startTime = System.currentTimeMillis();
//		Arrays.sort(a);
//		quickSort(a, 0, n - 1);
//		long endTime = System.currentTimeMillis();
//		System.out.printf("%.3f \n",(endTime - startTime) / 1000.0);
		
		
		//SORTING A COLLECTION
		ArrayList<String> s = new ArrayList<String>();
		String lemma = "fhkadhflkasvzxcbvmxbcvsgdfalsdfkerewglsdkfdsfg349182736478foiadfldkgvzbcvzxbvoweirqweiordvlkvblzkbvlakqwirioewufdv";
		
		for (int i = 0; i < n; i++) {
			int start = (int) (Math.random() * lemma.length());
			int end = Math.min(start + (int) (Math.random() * lemma.length()) / 2, lemma.length());
			s.add(lemma.substring(start, end));
		}
//		for (int i = 0; i < s.size(); i++)
//			System.out.println(s.get(i));

		long startTime = System.currentTimeMillis();
		Collections.sort(s, new StringComparatorByLength());
//		for (int i = 0; i < s.size(); i++)
//			System.out.println(s.get(i));
		long endTime = System.currentTimeMillis();
		System.out.printf("%.3f \n",(endTime - startTime) / 1000.0);
	}

}

