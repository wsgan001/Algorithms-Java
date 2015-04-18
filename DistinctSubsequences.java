//Given a string S and a string T, count the number of distinct subsequences of T in S.
//
//A subsequence of a string is a new string which is formed from the original 
//string by deleting some (can be none) of the characters without disturbing the 
//relative positions of the remaining characters. 
//(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//Here is an example:
//S = "rabbbit", T = "rabbit"
//
//Return 3.


public class DistinctSubsequences {
	
	public static int solve(String s, String t) {
		if (s.length() == 0 || t.length() == 0) 
			return 0;
		int m = s.length();
		int n = t.length();
		int[][] f = new int[m + 1][n + 1];
		
		for (int i = 0; i <= m; i++)
			f[i][0] = 1;
		
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					f[i][j] = Math.max(f[i][j], f[i - 1][j] + f[i - 1][j - 1]);
				} else {
					f[i][j] = f[i - 1][j];
				}
			}
		return f[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "rabbibit";
		String t = "rabbit";
		System.out.println(solve(s, t));
	}

}
