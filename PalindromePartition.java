//Given a string, a partitioning of the string is a palindrome partitioning 
//if every substring of the partition is a palindrome. For example, “aba|b|bbabb|a|b|aba” 
//is a palindrome partitioning of “ababbbabbababa”. Determine the fewest cuts needed for 
//palindrome partitioning of a given string. For example, minimum 3 cuts are needed for 
//“ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”. 
//If a string is palindrome, then minimum 0 cuts are needed. 
//If a string of length n containing all different characters, then minimum n-1 cuts are needed.

public class PalindromePartition {

	public static int solve(String s) {
		if (s == null || s.isEmpty()) 
			return 0;
		int n = s.length();
		int[][] f = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
			f[i][1] = 1;
		for (int j = 2; j <= n; j++) 
			for (int i = 1; i <= n - j + 1; i++) {
				f[i][j] = f[i][j - 1] + 1;
				for (int k = 0; k < j; k++) {
					String subs = s.substring(i + k - 1, i + j - 1);
					if (isPalin(subs) && f[i][j] > f[i][k] + 1) {
						f[i][j] = f[i][k] + 1;
					}
				}
					
			}
		return f[1][n] - 1;
	}
	
	public static int solve1(String s) {
		if (s == null || s.isEmpty())
			return 0;
		int n = s.length();
		int[][] f = new int[n][n];
		
		//initilization for l = 1;
		for (int i = 0; i < n; i++) {
			f[i][i] = 1;
		}
		
		for (int l = 2; l <= n; l++) 
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				f[i][j] = f[i][j - 1] + 1;
				if (isPalin(s.substring(i, j + 1))) {
					f[i][j] = 1;
				} else {
					for (int k = i + 1; k < j; k++)
						if (isPalin(s.substring(k, j + 1)))
							f[i][j] = Math.min(f[i][j], f[i][k] + 1);
				}
			}
			
		return f[0][n - 1] - 1;
	}
	
	//check palindrome in O(1)
	public static int solve2(String s) {
		if (s == null || s.isEmpty())
			return 0;
		int n = s.length();
		int[][] f = new int[n][n];
		boolean[][] p = new boolean[n][n];
		
		//initilization for l = 1;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				p[i][j] = false;
		
		for (int i = 0; i < n; i++) {
			f[i][i] = 1;
			p[i][i] = true;
		}
		
		for (int l = 2; l <= n; l++) 
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				f[i][j] = f[i][j - 1] + 1;
				if (l == 2) {
					p[i][j] = (s.charAt(i) == s.charAt(j));
				} else {
					p[i][j] = s.charAt(i) == s.charAt(j) && p[i+1][j-1];
				}
				if (p[i][j]) {
					f[i][j] = 1;
				} else {
					for (int k = i + 1; k < j; k++)
						if (p[k][j])
							f[i][j] = Math.min(f[i][j], f[i][k] + 1);
				}
			}
			
		return f[0][n - 1] - 1;
	}
	
	public static boolean isPalin(String s) {
		if (s == null || s.isEmpty()) 
			return true;
		int begin = 0;
		int end = s.length() - 1;
		while (begin < end) {
			if (s.charAt(begin) != s.charAt(end)) 
				return false;
			begin++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abac";
		System.out.println(solve2(s));
		
	}

}
