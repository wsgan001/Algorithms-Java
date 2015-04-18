package LinkedList;

import java.util.LinkedList;

public class AddTwoNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> a = new LinkedList<Integer>();
		LinkedList<Integer> b = new LinkedList<Integer>();
		a.addLast(2);
		a.addLast(4);
		a.addLast(3);
		a.addLast(3);
		a.addLast(3);
		a.addLast(3);
		a.addLast(3);
		
		b.addLast(5);
		
		
		LinkedList<Integer> c = new LinkedList<Integer>();
		c = addTwoLinkedList(a, b);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

	private static LinkedList<Integer> addTwoLinkedList(LinkedList<Integer> a, LinkedList<Integer> b) {
		LinkedList<Integer> re = new LinkedList<Integer>();
		int remainder = 0;
		int n = Math.min(a.size(), b.size());
		for (int i = 0; i < n; i++) {
			int d = remainder + a.get(i) + b.get(i);
			re.addLast(d % 10);
			remainder = d / 10;
		}
		if (a.size() > b.size()) {
			for (int i = n; i < a.size(); i++) {
				int d = remainder + a.get(i) ;
				re.addLast(d % 10);
				remainder = d / 10;
			}
		} else {
			for (int i = n; i < b.size(); i++) {
				int d = remainder + b.get(i) ;
				re.addLast(d % 10);
				remainder = d / 10;
			}
		}
		return re;
	}

}
