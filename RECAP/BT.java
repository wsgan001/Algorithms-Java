package RECAP;

public class BT {
	BTNode root;
	
	BT(int d) {
		root = new BTNode(d);
	}
	
	public void preorder() {
		preorder2(root);
		System.out.println();
	}
	
	public void preorder2(BTNode node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preorder2(node.left);
		
		preorder2(node.right);
		
	}
	
	//insert a new node to tree
	public boolean insert(int d) {
		if (root == null) {
			root = new BTNode(d);
			return true;
		}
		return insert2(root, d);
	}
	
	public boolean insert2(BTNode node, int d) {
		if (node == null) 
			return false;
		
		if (node.data <= d) {
			//d should be inserted in the right
			if (node.right == null) {
				node.right = new BTNode(d);
				return true;
			} else
				return insert2(node.right, d);
		}
		if (node.data > d)  {
			if (node.left == null) {
				node.left = new BTNode(d);
				return true;
			} else
				return insert2(node.left, d);
		}
		return false;
	}

	public int getMaxHeight() {
		return getMaxHeight2(root);
	}
	
	public int getMaxHeight2(BTNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(getMaxHeight2(node.left), getMaxHeight2(node.right));
	}
	
	public int getMinHeight() {
		return getMinHeight2(root);
	}
	
	public int getMinHeight2(BTNode node) {
		if (node == null)
			return 0;
		return 1 + Math.min(getMinHeight2(node.left), getMinHeight2(node.right));
	}

}
