import java.util.*;

class BalancedBracket {
	public static boolean isBalanced(String s) {
		int n = s.length();

		Stack<Character> st = new Stack<>();

		for(char ch : s.toCharArray()) {
			if(ch == '{' || ch == '(' || ch == '[') {
				st.push(ch);
			} else if(ch == '}' || ch == ')' || ch == ']') {
				if(st.isEmpty()) return false;

				char top = st.pop();

				if((top == '}' && top != '{')
					|| (top == ')' && top != '(')
					|| (top == ']' && top != '[')
				) {
					return false;
				}
			}
		}
		return st.isEmpty();
	}

	public static void main(String[] args) {
        String exp = "[()]{}{[()()](){";
        System.out.println(isBalanced(exp) 
                           ? "Balanced" : "Not Balanced");
	}
}