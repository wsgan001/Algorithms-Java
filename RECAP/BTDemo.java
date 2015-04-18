package RECAP;

import java.util.ArrayList;
import java.util.LinkedList;

public class BTDemo {
	
	
	public static ArrayList<LinkedList<Integer>> getNodeByLevel(BT bt) {
		ArrayList<LinkedList<Integer>> res = new ArrayList<LinkedList<Integer>>();
		int maxHeight = bt.getMaxHeight();
		for (int i = 0; i < maxHeight; i++) {
			LinkedList<Integer> x = new LinkedList<Integer>();
			res.add(x);
		}
		
		traverseByLevel(bt.root, 0, res);
		return res;
	}
	
	public static void traverseByLevel(BTNode node, int level, ArrayList<LinkedList<Integer>> res) {
		if (node == null)
			return;
		res.get(level).add(node.data);
		traverseByLevel(node.left, level + 1, res);
		traverseByLevel(node.right, level + 1, res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BT bt = new BT(3);
		bt.insert(5);
		bt.insert(2);
//		bt.insert(1);
		bt.insert(9);
		bt.insert(4);
		bt.preorder();
		ArrayList<LinkedList<Integer>> res = getNodeByLevel(bt);
		int level = 0;
		for (LinkedList<Integer> ll : res) {
			System.out.print("Level " + level + ": ");
			for (int i = 0; i < ll.size(); i++)
				System.out.print(ll.get(i) + " ");
			System.out.println();
			level++;
		}
	}

}
