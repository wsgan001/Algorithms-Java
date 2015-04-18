package DP;

public class BienDoiXau {

	public static int getDis(String a, String b) {
		if (a == null || b == null) return -1;
		if (a.isEmpty()) return b.length(); //insert all
		if (b.isEmpty()) return a.length(); //delete all
		int m = a.length();
		int n = b.length();
		
		int[][] f = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			f[i][0] = i;
		for (int j = 0; j <= n; j++)
			f[0][j] = j;
		f[0][0] = 0;
		
		for (int i = 1; i<= m; i++)
			for (int j = 1; j <= n; j++)
				if (a.charAt(i - 1) == b.charAt(j - 1))
					f[i][j] = f[i - 1][j - 1];
				else {
					f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
					f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
				}
		int i = m;
		int j = n;
		while (i > 0  && j > 0) {
			if (f[i][j] == f[i - 1][j - 1] && a.charAt(i - 1) == b.charAt(j - 1)) {
				i--; j--;
				continue;
			}
			if (f[i][j] == f[i][j - 1] + 1) {
				//insert
				System.out.println("INSERT " + b.charAt(j - 1) + " at " + (j-1));
				j--;
				continue;
			}
			if (f[i][j] == f[i - 1][j] + 1) {
				//insert
				System.out.println("DELETE " + a.charAt(i - 1) + " at " + (i-1));
				i--;
				continue;
			}
			if (f[i][j] == f[i - 1][j - 1] + 1 && a.charAt(i - 1) != b.charAt(j - 1)) {
				System.out.println("REPLACE " + a.charAt(i - 1) + " and " + b.charAt(j - 1));
				i--; j--;
				continue;
			}
		}
		
		return f[m][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "SUNDAY";
		String b = "SATURDAY";
		System.out.println(getDis(a, b));
	}

}
