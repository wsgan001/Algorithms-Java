package StackQueue;

import java.util.Stack;

//Implement queue using 2 stacks
public class MyQueue<E> {
	Stack<E> s1;
	Stack<E> s2;
	
	public MyQueue() {
		s1 = new Stack<E>();
		s2 = new Stack<E>();
	}
	
	public int size() {
		return s1.size() + s2.size();
	}
	
	public E dequeue() {
		if (s1.isEmpty()) {
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			if (s1.isEmpty()) 
				return null;
		}
		return s1.pop();
	}
	
	public void enqueue(E e) {
		s2.push(e);
	}
	
	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(7);
		q.enqueue(9);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
