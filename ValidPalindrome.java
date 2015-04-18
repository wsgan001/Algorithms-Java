//Given a string, determine if it is a palindrome, considering only alphanumeric characters 
//and ignoring cases.
//For example, "Red rum, sir, is murder" is a palindrome, 
//while "Programcreek is awesome" is not.

public class ValidPalindrome {

	public static boolean validPalin(String s) {
		if (s == null || s.isEmpty()) 
			return true;
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
//		System.out.println(s);
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
//		String s = "Red rum, sir, is murder";
		String s = "Programcreek";
		System.out.println(validPalin(s));
	}

}
