package Tree;
//binary tree
public class BT<E extends Comparable<E>> {
	BTNode<E> root;
	
	public BT() {
		root = null;
	}
	
	public BT(E e) {
		root = new BTNode<E>(e);
	}
	
	public boolean insert(E e) {
		if (root == null) {
			root = new BTNode<E>(e);
			return true;
		}
		return insert2(root, e);
	}
	
	public boolean insert2(BTNode node, E e) {
		if (node == null)
			return false;
		if (node.item.compareTo(e) < 0) {
			if (node.right == null) {
				node.right = new BTNode<E>(e);
				return true;
			}
			return insert2(node.right, e);
		} else {
			if (node.left == null) {
				node.left = new BTNode<E>(e);
				return true;
			}
			return insert2(node.left, e);
		}
	}
	
	public void traverse() {
		if (this.root == null) return;
		printPreOrder(root);
	}
	
	public void printPreOrder(BTNode node) {
		if (node == null) return;
		System.out.println(node.item);
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
	
	public int minHeight(BTNode node) {
		if (node == null) return 0;
		return 1 + Math.min(minHeight(node.left), minHeight(node.right));
	}
	
	public int getMinHeight() {
		return minHeight(root);
	}
	
	public int maxHeight(BTNode node) {
		if (node == null) return 0;
		return 1 + Math.max(maxHeight(node.left), maxHeight(node.right));
	}
	
	public int getMaxHeight() {
		return maxHeight(root);
	}
	
	public boolean isBalance() {
		return (getMaxHeight() - getMinHeight()) <= 1;
	}
}
