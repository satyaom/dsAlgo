import java.util.*;

class KMP {
	public static int[] getLPS(String s) {
		int n = s.length();
		int[] lps = new int[n];
		int len = 0, i = 1;
		while(i < n) {
			if(s.charAt(i) == s.charAt(len)) {
				lps[i] = ++len;
				i++;
			} else {
				if(len != 0) {
					/**
					* we check in dp what is the lps of len-1,
					* to start compare after the lps of len-1
					* of checking from 0th index
					* */
					len = lps[len-1];
				}
				else{
					i++;
				} 
			}
		}
		return lps;
	}  

	// Time complexity O(n1 + n2), space O(n2)
	public static void matchPattern(String s1, String s2) {
		int[] lps = getLPS(s2);
		int i = 0, j = 0, n1 = s1.length(), n2 = s2.length();
		while(i < n1) {
			if(s1.charAt(i) == s2.charAt(j)) {
				if(j == n2-1){
					System.out.println(i-n2+1);
					j = lps[j];
				} else {
					j++;
				}
				i++;
			} else {
				if(j != 0) j = lps[j-1];
				else i++;
			}
		}
	}

	public static void main(String[] args) {

		matchPattern("AAAAABAAABA", "AAAA");
		// System.out.println(Arrays.stream(getLPS("aaaabaacdaaaabaaaab")).boxed().toList());
	}
}