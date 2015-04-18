package RECAP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Fraction {
	int p;
	int q;
	
	Fraction(int p, int q) {
		this.p = p;
		this.q = q;
	}
	
	public String toString() {
		return p + " / " + q;
	}
	
	public int hashCode() {
		int prime = 31;
		int result = prime * p + 1;
		result = result * q + 1;
		return result;
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		Fraction f = (Fraction) o;
		return (this.p == f.p && this.q == f.q);
	}
	
}

class FractionComparator implements Comparator<Fraction> {

	@Override
	public int compare(Fraction f1, Fraction f2) {
		if (f1.p * f2.q == f2.p * f1.q)
			return 0;
		if (f1.p * f2.q > f2.p * f1.q)
			return 1;
		return -1;
	}
	
}

public class HashSetDemo {
	
	
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
	
	//return all p/q such that p = 1..m; q = 1..p
	public static ArrayList<Fraction> getAll(int m, int n) {
		ArrayList<Fraction> res = new ArrayList<Fraction>();
		for (int i = m; i <= n; i++)
			for (int j = 1; j < i; j++) {
				int d = gcd(i, j);
				Fraction f = new Fraction(i / d, j / d);
				boolean was = false;
				for (Fraction fw : res)
					if (fw.equals(f)) {
						was = true;
						break;
					}
				if (!was)
					res.add(f);
			}
		Collections.sort(res, new FractionComparator());		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		HashSet<Integer> hi = new HashSet<Integer>();
//		hi.add(4);
//		hi.add(7);
//		hi.add(9);
//		hi.add(7);
//		
//		for (int i : hi)
//			System.out.println(i);
//		
//		HashSet<String> hs = new HashSet<String>();
//		hs.add("kien");
//		hs.add("tran");
//		hs.add("ki");
//		hs.add("kien");
//		hs.add("trung");
//		for (String s : hs)
//			System.out.print(s + " ");
//		System.out.println();
//		hs.remove("trung");
//		for (String s : hs)
//			System.out.print(s + " ");
		ArrayList<Fraction> res = getAll(2,4);
		for (Fraction f : res)
			System.out.println(f.toString());
	}

}
