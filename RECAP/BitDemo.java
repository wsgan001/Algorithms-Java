package RECAP;

public class BitDemo {
	
	public static int getBit(int n, int i) {
		return 1 & (n >> i);
	}
	
	public static int turnOff(int n, int i) {
		return n & ~(1 << i);
	}
	
	public static int turnOn(int n, int i) {
		return n & (1 << i);
	}
//	You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
//	Write a method to set all bits between i and j in N equal to M (e.g., M becomes a
	
//	substring of N located at i and starting at j).
	public static int updateBits(int n, int m, int i, int j) {
		int max = ~0; //all 1
		int left = max - ((1 << j) - 1);
		int right = (1 << i) - 1;
		int mask = left | right;
		return (mask & n) | (m << i);
		
	}
	
	public static void main(String[] args) {
		System.out.println(getBit(2,8));
	}
}
