package Tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeDemo {
//	Given a sorted (increasing order) array, 
//	write an algorithm to create a binary tree with minimal height	
	
	public static BTNode generateFromArray(int[] a,int begin, int end) {
		if (begin > end) 
			return null;
		if (begin == end) 
			return new BTNode(a[begin]);
		int mid = (begin + end) / 2;
		BTNode<Integer> node = new BTNode<Integer>(a[mid]);
		node.left = generateFromArray(a, begin, mid - 1);
		node.right = generateFromArray(a, mid + 1, end);
		return node;
	}
	
//	Given a binary search tree, design an algorithm which creates 
//	a linked list of all the nodes at each depth (i e , if you have 
//	a tree with depth D, you’ll have D linked lists)
	public static ArrayList<LinkedList<Integer>> findLevelLinkedList(BT bt) {
		ArrayList<LinkedList<Integer>> re = new ArrayList<LinkedList<Integer>>();
		int maxHeight = bt.getMaxHeight();
		for (int i = 0; i < maxHeight; i++)
			re.add(new LinkedList<Integer>());
		int level = 0;
		traverseByLevel(bt.root, level, re);
		return re;
	}
	
	public static void traverseByLevel(BTNode<Integer> node, int level, ArrayList<LinkedList<Integer>> r) {
		if (node == null) return;
		r.get(level).add((int)node.item);
		traverseByLevel(node.left, level + 1, r);
		traverseByLevel(node.right, level + 1, r);
	}
	
	public static void main(String[] args) {
		BT<Integer> bt = new BT<Integer>();
		bt.insert(2);
		bt.insert(4);
		bt.insert(5);
		bt.insert(3);
		bt.insert(8);
		bt.insert(1);
//		bt.traverse();
//		System.out.println(bt.getMinHeight());
//		System.out.println(bt.getMaxHeight());
//		System.out.println(bt.isBalance());
		int[] a = {1,2,3,4,5,8};
		BTNode root = generateFromArray(a, 0, a.length - 1);
		BT<Integer> b = new BT<Integer>();
		b.root = root;
//		b.traverse();
		ArrayList<LinkedList<Integer>> result = findLevelLinkedList(bt);
		for (LinkedList<Integer> l : result) {
			for (int i = 0; i < l.size(); i++) {
				System.out.print(l.get(i) + " ");
			}
			System.out.println();
		}
	}
}
