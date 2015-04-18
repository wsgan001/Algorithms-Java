package Tree;

public class BTNode<E extends Comparable<E>> {
	public E item;
	public BTNode<E> left;
	public BTNode<E> right;
	
	public BTNode() {
		item = null;
		left = null;
		right = null;
	}
	
	public BTNode(E e) {
		item = e;
		left = null;
		right = null;
	}
}
