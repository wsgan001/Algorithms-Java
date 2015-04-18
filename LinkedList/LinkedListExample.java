package LinkedList;

import java.util.HashSet;

public class LinkedListExample {
	
//	Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//	For example,
//
//	Given 1->1->2, return 1->2.
//	Given 1->1->2->3->3, return 1->2->3.	
	public static Node deleteDupSorted(Node head) {
		if (head == null || head.next == null)
			return head;
		Node p = head;
		while (p != null && p.next != null) {
			if (p.data == p.next.data) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
			
		}
		return head;
	}
	
	
//	Write code to remove duplicates from an unsorted linked list
	public static void deleteDup(Node n) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node pre = n;
		while (n != null) {
			if (set.contains(n.data)) {
				pre.next = n.next;
			} else {
				set.add(n.data);
				pre = n;
			}
			n = n.next;
		}
	}
	
//	Implement an algorithm to find the nth to last element of a singly linked list
	public static Node kLast(Node n, int k) {
		if (n == null) return null;
		Node p1 = new Node(n);
		Node p2 = new Node(n);
		for (int i = 0; i < k; i++) {
			if (p1 == null) return null;
			p1 = p1.next;
		}
			
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	
//	Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node
//	EXAMPLE
//	Input: the node ‘c’ from the linked list a->b->c->d->e
//	Result: nothing is returned, but the new linked list looks like a->b->d->e	
	public static void deleteMid(Node n) {
		if (n == null) return;
		Node pre = n;
		n = n.next;
		while (n != null) {
			pre.data = n.data;
			pre = n;
			n = n.next;		
		}
	}
	
//	You have two numbers represented by a linked list, where each node contains 
//	a single digit The digits are stored in reverse order, such that the 1’s 
//	digit is at the head of the list Write a function that adds the two numbers 
//	and returns the sum as a linked list
//	EXAMPLE
//	Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
//	Output: 8 -> 0 -> 8	
	public static Node add(Node a, Node b) {
		if (a == null) return b;
		if (b == null) return a;
		
		Node result = new Node((a.data + b.data)%10);
		int remainder = (a.data + b.data) / 10;
		a = a.next;
		b = b.next;
		while (a != null && b!= null) {
			int t = a.data + b.data + remainder;
			result.appendToTail(t % 10);
			remainder = t / 10;
			a = a.next;
			b = b.next;
		}
		
		if (a == null) {
			while (b != null || remainder != 0) {
				
				int t = (b != null) ? b.data : 0;
				t += remainder;
				result.appendToTail(t % 10);
				remainder = t / 10;
				if ( b != null) b = b.next;
			}
		}
		if (b == null) {
			while (a != null || remainder != 0) {
				int t = (a != null) ? a.data : 0;
				t += remainder;
				result.appendToTail(t % 10);
				remainder = t / 10;
				if ( a != null) a = a.next;
			}
		}
		return result;
	}
	
	//Reserve a linkedlist
	public static Node reserve(Node head) {
		if (head == null || head.next == null) 
			return head;
		Node pre = head;
		Node cur = head.next;
		while (cur != null) {
			Node temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		head.next = null;
		return pre;
	}
	//merge two list (4,2) + (1,3,5,6) -> (4,1,2,3,5,6)
	public static Node merge(Node p1, Node p2) {
		if (p1 == null) return p2;
		if (p2 == null) return p1;
		Node result = p1;
		while (p2 != null && p1 != null) {
			Node temp1 = p1.next;
			Node temp2 = p2.next;
			
			p1.next = p2;
			if ( temp1 != null) 
				p2.next = temp1;
			else p2.next = temp2;
			
			p1 = temp1;
			p2 = temp2;
		}
		return result;
	}
	//merge two sorted linked list
	public static Node mergeSortList(Node head1, Node head2) {
		Node p1 = head1;
		Node p2 = head2;
		
		Node head = new Node(0);
		Node p = head;
		while (p1 != null && p2 != null) {
			if (p1.data  < p2.data) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}
		
		if (p1 != null) 
			p.next = p1;
		if (p2 != null)
			p.next = p2;
		
		return head.next;
	}
	
	
	//check if a linkedlist is cirlular using fast and slow technique
	public static boolean hasCycle(Node head) {
		if (head == null || head.next == null)
			return false;
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast)
				return true;
		}
		return false;
	}
	
	
	
	
	
	public static void printLinkedList(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node n = new Node(1);
		for (int i = 2; i < 6; i++) {
			n.appendToTail(i);
		}
//		deleteDup(n);
//		while (n != null) {
//			System.out.print(n.data + " " );
//			n = n.next;
//		}
		
//		System.out.println(kLast(n, 3).data);
		
		Node a = new Node(1);
		
		a.appendToTail(5);
		
		Node b = new Node(2);
		b.appendToTail(2);
		b.appendToTail(4);
		b.appendToTail(4);
		b.appendToTail(4);
		b.appendToTail(4);
		b.appendToTail(8);
		b.appendToTail(8);
		
		Node c = deleteDupSorted(b);
		printLinkedList(c);
//		Node c = mergeSortList(a, b);
//		printLinkedList(c);
		
//		System.out.println(hasCycle(b));
//		Node c = merge(b, a);
//		printLinkedList(c);
		
//		Node c = add(a, b);
//		printLinkedList(c);
	}
}
