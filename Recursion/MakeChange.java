package Recursion;
//Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and 
//pennies (1 cent), write code to calculate the number of ways of representing n cents

public class MakeChange {
	
	public static int makeChange(int n, int denom) {
		int nextDenom = 0;
		if (n == 1) return 1;
		switch (denom) {
			case 25: nextDenom = 10; break;
			case 10: nextDenom = 5; break;
			case 5: nextDenom = 1; break;
			case 1: return 1;
		}
		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += makeChange(n - i * denom, nextDenom);
		}
		return ways;
	}
	
	public static int makeChangeDP(int n) {
		int[] f = new int[n + 1];
		f[0] = 1;
		int[] denoms = {1,5,10,25};
		for (int i = 1; i <= n; i++) 
			for (int j = 0; j < 4; j++)
				if (i >= denoms[j])
					f[i] = f[i] + f[i-denoms[j]];
		return f[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(makeChange(27,25));
		System.out.println(makeChangeDP(19));
	}

}
