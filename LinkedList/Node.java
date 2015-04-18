package LinkedList;

public class Node {
	int data;
	Node next;
	
	public Node(int d) {
		this.data = d;
		next = null;
	}
	
	public Node(Node n) {
		this.data = n.data;
		this.next = n.next;
	}
	
	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}
