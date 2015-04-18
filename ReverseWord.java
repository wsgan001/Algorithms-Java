
public class ReverseWord {

	public static String reverse(String s) {
		String result = "";
		if (s == null || s.isEmpty()) return s;
		String[] a = s.trim().split(" ");
		for (int i = a.length - 1; i >= 0; i--)
			result += a[i] + " ";
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " The sky is blue";
		System.out.println(reverse(s));
	}

}
