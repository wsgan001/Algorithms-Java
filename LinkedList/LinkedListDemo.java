package LinkedList;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.add(1);
		ll.add("e");
		ll.add("a");
		ll.add("kien");
		System.out.println(ll);
		ll.remove(2);
		System.out.println(ll);
		ll.remove("kien");
		System.out.println(ll);
		ll.removeLast();
		System.out.println(ll);
		
	}

}
