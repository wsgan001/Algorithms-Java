package StackQueue;

public class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		next = null;
	}
	
	public void appendToTail(int data) {
		Node n = this;
		Node end = new Node(data);
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}
