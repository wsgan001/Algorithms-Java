
public class Palindrome {

	public static String longestPalindrome(String s) {
		if (s.isEmpty())
			return null;
		
		if (s.length() == 1)
			return s;
		
		String result = s.substring(0, 1);
		String sp;
		for (int i = 0; i < s.length(); i++) {
			sp = expand(s,i,i);
			if (result.length() < sp.length()) result = sp;
			sp = expand(s,i,i+1);
			if (result.length() < sp.length()) result = sp;
		}
		return result;
	}
	
	public static String expand(String s, int i, int j) {
		
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
				i--;
				j++;
		}
		
		return s.substring(i+1, j);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1214141215";
		System.out.println(longestPalindrome(s));
	}

}
