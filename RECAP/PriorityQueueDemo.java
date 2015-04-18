package RECAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 5;  i > 1; i--)
			q.add(i);
		q.add(10);
		q.add(22);
		q.add(13);
		while (!q.isEmpty()) 
			System.out.println(q.poll());
		System.out.println("--------------------------------");
		PriorityQueue<String> qs = new PriorityQueue<String>(10, new StringComparatorByLength());
		qs.add("short");
		qs.add("very long long text");
		qs.add("normal text");
		while (!qs.isEmpty())
			System.out.println(qs.poll());
		System.out.println("--------------------------------");
		//how to use comparator for array
		ArrayList<String> as = new ArrayList<String>();
		as.add("normal text");
		as.add("short");
		as.add("very long long text");
		for (int i = 0; i < as.size(); i++)
			System.out.println(as.get(i));
		Collections.sort(as, new StringComparatorByLength());
		for (int i = 0; i < as.size(); i++)
			System.out.println(as.get(i));
	}
}

class StringComparatorByLength implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		if (s1.length() < s2.length())
			return -1;
		else
			if (s1.length() > s2.length())
				return 1;
			else 
				return 0;
	}
	
}
