package Recursion;
//greatest common devider
public class GCD {

	public static long gcd(long a, long b) {
		if (b == 0) 
			return a;
		else 
			return gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(8234,17413412));
	}

}
