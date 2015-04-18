import java.util.PriorityQueue;

//Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7
//3,5,7,9,15,21,25,27,35,45,49
public class MagicNumber {

	public static int getMagicNumber(int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(100);
		q.add(1);
		for (int i = 0; i < k; i++) {
			int val = q.poll();
			if (!q.contains(val * 3))
				q.add(val * 3);
			if (!q.contains(val * 5))
				q.add(val * 5);
			if (!q.contains(val * 7))
				q.add(val * 7);
		}
		return q.poll();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 20; i++)
			System.out.println(getMagicNumber(i));
	}

}
