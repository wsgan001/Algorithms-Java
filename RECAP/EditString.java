package RECAP;

public class EditString {

	public static int editString(String a, String b) {
		int m = a.length();
		int n = b.length();
		
		//f[i][j] is the minimum step need to transform a[1..i] to b[1..j]
		int[][] f = new int[m + 1][n + 1];
		//initialization
		for (int i = 0; i <= m; i++)
			f[i][0] = i;
		for (int j = 0; j <= n; j++)
			f[0][j] = j;
		//processing
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				f[i][j] = f[i - 1][j - 1] + 1;	//using REPLACE
				if (a.charAt(i - 1) == b.charAt(j - 1))
					f[i][j] = f[i - 1][j - 1];
				else {
					f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
					f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
				}
			}
		
		//tracing
		int i = m;
		int j = n;
		while (i > 0 && j > 0) {
			if (f[i][j] == f[i - 1][j - 1] && a.charAt(i - 1) == b.charAt(j - 1)) {
				i--;
				j--;
				continue;
			}
			if (f[i][j] == f[i - 1][j - 1] + 1 && a.charAt(i - 1) != b.charAt(j - 1)) {
				System.out.println("REPLACE " + a.charAt(i - 1) + " with " + b.charAt(j - 1));
				i--;
				j--;
				continue;
			}
			if (f[i][j] == f[i - 1][j] + 1 && a.charAt(i - 1) != b.charAt(j - 1)) {
				System.out.println("DELETE " + a.charAt(i - 1) );
				i--;
				continue;
			}
			if (f[i][j] == f[i][j - 1] + 1 && a.charAt(i- 1) != b.charAt(j - 1)) {
				System.out.println("INSERT " + b.charAt(j - 1) + " at " + i);
				j--;
				continue;
			}
				
		}
		
		return f[m][n];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "SUNDAY";
		String b = "SATURDAY";
		System.out.println(editString(b, a));
	}

}
