package Recursion;

public class HanoiTower {

	public static void move(int n, int from, int to) {
		if (n == 1) {
			System.out.println(from + " --> " + to);
			return;
		}
		int temp = 6 - from - to;
		move(n - 1, from, temp);
		move(1, from, to);
		move(n - 1, temp, to);	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		move(3, 1, 3);
	}

}
