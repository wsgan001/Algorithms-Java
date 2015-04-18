package RECAP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ImmutableQueue<E> {

	E[] queue;
	int size;
	
	public ImmutableQueue() {
		queue = null;
		size = 0;
	}
	
	public ImmutableQueue(E[] queue) {
		this.queue = queue;
		this.size = queue.length;
	}
	
	public ImmutableQueue<E> enqueue(E e) {
		if (e == null) {
			throw new IllegalArgumentException();
		}
//		E[] clone = (E[]) Array.newInstance(e.getClass(), size + 1);
		E[] clone = (E[]) new Object[size + 1];
		if (queue != null)
			System.arraycopy(queue, 0, clone, 0, this.size);
		clone[size] = e;
		return new ImmutableQueue<E>(clone);
	}
	
	public ImmutableQueue<E> dequeue() {
		if (size == 0) {
			throw new NullPointerException();			
		}
		E[] clone = (E[]) new Object[size - 1];
		System.arraycopy(queue, 1, clone, 0, size - 1);
		return new ImmutableQueue<E>(clone);
	}
	
	public String toString() {
		return "size: " + this.size + "\n" + Arrays.toString(queue); 
	}
	
	public int size() {
		return this.size;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImmutableQueue<Integer> q = new ImmutableQueue<Integer>();
		
		ImmutableQueue<Integer> q1 = q.enqueue(2);
		System.out.println(q.toString());
		System.out.println(q1.toString());
		q = q1;

		q1 = q.enqueue(8);
		System.out.println(q.toString());
		System.out.println(q1.toString());
		q = q1;

		q1 = q.enqueue(9);
		System.out.println(q.toString());
		System.out.println(q1.toString());
		q = q1;
		
		q1 = q.dequeue();
		System.out.println(q.toString());
		System.out.println(q1.toString());
		q = q1;
		
	}

}
