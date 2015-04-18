// you can also use imports, for example:
import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Rakuten {
    
    public static int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
        // write your code in Java SE 8
        long s1 = area(K, L, M, N);
        if (s1 == -1) return -1;
        
        long s2 = area(P, Q, R, S);
        if (s2 == -1) return -1;
        
        int x1 = Math.max(K, P);
        int x2 = Math.min(M, R);
        int y1 = Math.max(L, Q);
        int y2 = Math.min(N, S);
        // System.out.println(x1 + " , " + y1);
        // System.out.println(x2 + " , " + y2);
        long si = area(x1, y1, x2, y2);
        long result = s1 + s2 - si;
        if (result > Integer.MAX_VALUE) return -1;
        return (int)result;
    }
    
    public static long area(int x1, int y1, int x2, int y2) {
        long x = (long)x2 - (long)x1;
        long y = (long)y2 - (long)y1;
        long s = (long)x * (long)y;
        if ( s > Integer.MAX_VALUE )
            return - 1;
        return s;
    }
    
    public static void main(String[] args) {
    	System.out.println(solution(-2147483648,-1, 0, 0, 0 , 0, 1,1));
    }
}

