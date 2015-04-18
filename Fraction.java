import java.util.HashSet;
import java.util.Set;

public class Fraction {
	public int p;
	public int q;
	
	Fraction(int p, int q) {
		this.p = p;
		this.q = q;
	}
	
	public static int getGCD(int a, int b) {
		if (b == 0)
			return a;
		else 
			return getGCD(b, a % b);
	}
	
	public static Fraction reduce(Fraction f) {
		int c = getGCD(f.p, f.q);
		return new Fraction(f.p / c, f.q / c);
	}
	
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + p;
	    result = prime * result + q;
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    Fraction other = (Fraction) obj;
	    if (p != other.p)
	        return false;
	    if (q != other.q)
	        return false;
	    return true;
	}	
	
	public static HashSet<Fraction> getAll(int m, int n) {
		HashSet<Fraction> res = new HashSet<Fraction>();
		for (int p = m; p <= n; p++)
			for (int q = 1; q < p; q++) {
				Fraction f = new Fraction(p,q);
				Fraction fr = reduce(f);
				boolean was = false;
				for (Fraction i : res) {
					if (i.equals(fr)) {
						was = true;
						break;
					}
				}
				if (!was) 
					res.add(fr);
			}
		return res;
	}
	
	public static void print(Fraction f) {
		System.out.println(f.p + "/" + f.q);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Fraction> res = getAll(4, 6);
		for (Fraction f : res)
			print(f);
	}

}
