import java.util.*;

class KMP {
	public static int[] lps(String s) {
		int i = 1;
		int len = 0;
		int[] lps = new int[s.length()];
		while(i < s.length()) {
			if(s.charAt(i) == s.charAt(len)) {
				lps[i] = ++len;
				i++;
			} else {
				if(len != 0) len = lps[len - 1];
				else i++;
			}
		}
		return lps;
	}

	public static void kmp(String s1, String s2) {
		int[] lps = lps(s2);
		int i = 0;
		int j = 0;
		while(i < s1.length()) {
			if(s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else {
				if(j != 0) j = lps[j-1];
				else i++;
			}
			if(j == s2.length()) {
				System.out.println("found at: "+ (i - s2.length()));
				j = lps[j-1];
			}
		}
	}

	public static void main(String[] args) {
		String txt = "aabaacaadaabaaba"; 
        String pat = "aaba"; 
		kmp(txt, pat);
		// System.out.println(Arrays.stream(lps("AAAAABAAABA")).boxed().toList());
	}
}