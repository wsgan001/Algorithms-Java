import java.util.ArrayList;


public class StringPatternMatching {

	public static ArrayList<Integer> getPosNative(String s, String pat) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (s == null || s.isEmpty() || s.length() < pat.length()) 
			return res;
		int n = s.length();
		int m = pat.length();
		for (int i = 0; i <= n - m; i++) {
			int j;			
			for (j = 0; j < m; j++) 
				if (s.charAt(i + j) != pat.charAt(j))
					break;
			if (j == m)
				res.add(i);
		}
		return res;
	}
	
	public static ArrayList<Integer> getPosKMP(String s, String pat) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (s == null || s.isEmpty() || s.length() < pat.length()) 
			return res;
		int n = s.length();
		int m = pat.length();
		//construct the longest suffix-prefix
		int[] lsp = new int[m];
		lsp[0] = 0;
		int q = 0;
		for (int i = 1; i < m; i++) {
			if (pat.charAt(i) == pat.charAt(q)) {
				lsp[i] = lsp[i-1] + 1;
				q++;
			}
			else {
				lsp[i] = 0;
				q = 0;
			}
		}
		for (int i = 0; i < m; i++)
			System.out.print(lsp[i] + " ");
		//processing
		
		int j = 0;  // Number of chars matched in pattern
		for (int i = 0; i < n; i++) {
	        if (j > 0 && s.charAt(i) != pat.charAt(j)) {
	            // Fall back in the pattern
	            j = lsp[j - 1];  // Strictly decreasing
	        }
	        if (s.charAt(i) == pat.charAt(j)) {
	            // Next char matched, increment position
	            j++;
	            if (j == pat.length()) {
	            	res.add(i - (j - 1));
	            	j = 0;
	            }
	        }
	    }
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s =   "ababeababde";
		String pat = "abaab";
		ArrayList<Integer> res = getPosKMP(s, pat);
//		ArrayList<Integer> res = getPosKMP("BACDGABCDA","ABCD");
		for (int i : res) 
			System.out.println(i);
	}

}
