package RECAP;

import java.util.HashSet;
import java.util.Set;

public class LinkedListDemo {

	public static void print(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
	
	//delete a node in linkedlist
	public static Node delete(Node head, int d) {
		Node n = head;
		//case 1 : head is equal d
		if (n.data == d) {
			return head.next;
		}
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	
	//remove dup from sorted linkedlist
	public static Node removeDupSorted(Node head) {
		if (head == null || head.next == null)
			return head;
		Node pre = head;
		Node cur = head.next;
		while (cur != null) {
			if (cur.data == pre.data) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}
	
	//remove dup from unsorted linkedlist
	public static Node removeDup(Node head) {
		if (head == null || head.next == null)
			return head;
		HashSet<Integer> was = new HashSet<Integer>();
		Node pre = head;
		Node cur = pre;
		while (cur != null) {
			if (was.contains(cur.data)) {
				pre.next = cur.next;
			} else {
				was.add(cur.data);
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}
	
//	Implement an algorithm to find the nth to last element of a singly linked list
	public static Node getKLast(Node head, int k) {
		Node p1 = head;
		Node p2 = head;
		for (int i = 0; i < k; i++) {
			p1 = p1.next;
			if (p1 == null && i < k - 1)
				return null;
		}
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	//add two number
	public static Node add(Node heada, Node headb) {
		Node a = heada;
		Node b = headb;
		if (a == null)
			return b;
		if (b == null)
			return a;
		Node res = new Node((a.data + b.data)%10);
		int carry = (a.data + b.data)/10;
		a = a.next;
		b = b.next;
		
		while (a != null && b != null) {
			int d = (a.data + b.data + carry) % 10;
			carry = (a.data + b.data + carry) / 10;
			res.appendToTail(d);
			a = a.next;
			b = b.next;
		}
		while (a != null) {
			int d = (a.data + carry) % 10;
			carry = (a.data + carry) / 10;
			res.appendToTail(d);
			a = a.next;
		}
		while (b != null) {
			int d = (b.data + carry) % 10;
			carry = (b.data + carry) / 10;
			res.appendToTail(d);
			b = b.next;
		}
		if (carry == 1)
			res.appendToTail(1);
		return res;
	}
	
	//reverse order of a linkedlist
	public static Node reverse(Node head) {
		Node pre = head;
		Node cur = pre.next;
		while (cur != null) {
			Node temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		head.next = null;
		return pre;
	}
	
	//merge two sorted linkedlist
	public static Node mergeSorted(Node head1, Node head2) {
		Node result = new Node(0);
		Node res = result;
		Node p1 = head1;
		Node p2 = head2;
		while (p1 != null && p2 != null) {
			if (p1.data < p2.data) {
				res.next = new Node(p1.data);
				p1 = p1.next;
			} else {
				res.next = new Node(p2.data);
				p2 = p2.next;
			}
			res = res.next;
		}
		if (p1 != null)
			res.next = p1;
		if (p2 != null)
			res.next = p2;
		return result.next;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Node n = new Node(1);
//		print(n);
//		n.appendToTail(1);
//		n.appendToTail(2);
//		n.appendToTail(5);
//		n.appendToTail(19);
//		n.appendToTail(5);
//		n.appendToTail(1);
//		print(n);
//		n = removeDup(n);
//		print(n);
		
//		Node n = new Node(1);
//		n.appendToTail(1);
//		n.appendToTail(1);
//		n.appendToTail(2);
//		n.appendToTail(2);
//		n.appendToTail(6);
//		print(n);
//		n = removeDupSorted(n);
//		n.appendToTail(7);
//		n.appendToTail(8);
//		n.appendToTail(9);
//		print(n);
//		Node k = getKLast(n, 1);
//		print(k);
		
		Node a = new Node(1);
		a.appendToTail(29);
		Node b = new Node(3);
		b.appendToTail(9);
		Node c = mergeSorted(a, b);
		print(c);
		
//		Node n = new Node(1);
//		n.appendToTail(2);
//		n.appendToTail(3);
//		n.appendToTail(8);
//		n = reverse(n);
//		print(n);
	}

}


class Node {
	int data;
	Node next = null;
	
	Node(int d) {
		this.data = d;
		this.next = null;
	}
	
	void appendToTail(int d) {
		Node n = this;
		while (n.next != null)
			n = n.next;
		n.next = new Node(d);
	}
}
