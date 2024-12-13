class ConsicutiveString {

	public static string getConsecutiveString(String s) {
		Stack<Char> st = new Stack<>();
		String res = "";
		int i = 1;
		st.add(s.charAt(0));

		while(i < s.length()) {
			char ch = s.charAt(i);
			char stCh = st.peek();
			if(ch.equals(stCh) && i > 1) {
				st.pop();
				char stch1 = st.peek();
				if(ch.equals(stch1)) {
					st.pop();
				} else {
					st.add(stch);
					st.add(ch);
				}
			}
			i++;
		}

		while(st.empty()) {
			res += st.pop();
		}

		return res.reverse();
	}

}