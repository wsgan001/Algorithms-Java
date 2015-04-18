import java.util.*;

public class ValidParenthesis {
	
	public static boolean valid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if (map.keySet().contains(current)) {
				st.push(current);
			} else if (map.values().contains(current)) {
				if (st.isEmpty() || map.get(st.peek()) != current )
					return false;
				st.pop();
			}
		}
		return st.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{()}(){(})[]";
		System.out.println(valid(s));
	}

}
