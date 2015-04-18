//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
//
//The matching should cover the entire input string (not partial).
//
//The function prototype should be:
//bool isMatch(const char *s, const char *p)
//
//Some examples:
//isMatch("aa","a") return false
//isMatch("aa","aa") return true
//isMatch("aaa","aa") return false
//isMatch("aa", "a*") return true
//isMatch("aa", ".*") return true
//isMatch("ab", ".*") return true
//isMatch("aab", "c*a*b") return true
		
//SOLUTION
//Overall, there are 2 different cases: 1) the second char of pattern is "*" , and 2) the second char of pattern is not "*".
//
//For the 1st case, if the first char of pattern is not ".", the first char of pattern and string should be the same. Then continue to match the left part.
//
//For the 2nd case, if the first char of pattern is "." or first char of pattern == the first i char of string, continue to match the left.
//
//Be careful about the offset.

public class RegularExpression {

	public static boolean isMatch(String s, String p) {
		if (p.length() == 0) 
			return s.length() == 0;
		if (p.length() == 1 || p.charAt(1) != '*') {
			if ( (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))  ||  (s.length() < 1) ) 
				return false;
			return isMatch(s.substring(1),p.substring(1));
		} else {
			int len = s.length();
			int i = -1;
			while (i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
				if (isMatch(s.substring(i+1), p.substring(2))) 
					return true;
				i++;
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("aab","a*b*"));

	}

}
