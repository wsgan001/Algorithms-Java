package FINAL;

public class LinkedListDemo {

	public static void print(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
	
	public static Node reverse(Node head) {
		if (head == null || head.next == null)
			return head;
		Node cur = head;
		Node pre = cur;
		while (cur != null) {
			Node temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		head.next = null;
		return pre;
	}
	
	public static Node delete(Node head, int d) {
		if (head == null || head.data == d)
			return null;
		Node cur = head;
		while (cur.next != null) {
			if (cur.next.data == d) {
				cur.next = cur.next.next;
				return head;
			}
			cur = cur.next;
		}
		return head;
	}
	
	//remove dup from sorted
	//remove dup from unsorted
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(1);
		n.appendToTail(3);
		n.appendToTail(9);
		n.appendToTail(6);
		n.appendToTail(2);
		print(n);
		n = reverse(n);
		print(n);
		n = delete(n, 6);
		n = delete(n, 10);
		print(n);
	}

}

class Node {
	int data;
	Node next;
	
	Node(int d) {
		this.data = d;
		this.next = null;
	}
	
	public void appendToTail(int d) {
		Node n = this;
		while (n.next != null)
			n = n.next;
		n.next = new Node(d);
	}
}
