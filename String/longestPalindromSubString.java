import java.io.*;
import java.util.*;


// forgeeksskeegfor -> geeksskeeg
class LongestPalindromSubString {
	//Solved Using DP
	static String longestPdrmSubstr(String s) {
		int n = s.length();
		boolean[][] isPal = new boolean[n][n];
		int maxLen = 1;
		int start = 0;

		// to make isPal true for single char
		for(int i = 0; i < n; i++) {
			isPal[i][i] = true;
		}

		/**
		 * Necessary step for base values
		 * by this you dont have to calculate for 
		 * isPal(2, 3) -> isPal(3, 2) 
		 * since it is going reverse direction it is better
		 * to compare with previous value
		**/
		for(int i = 0; i < n-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				isPal[i][i+1] = true;
				start = i;
				maxLen = 2;
			}
		}

		//It is the travesal of matrix which end with fix column
		//but the end of row is variable therefore
		//we going to traverse in such way where we gonna write
		//column loop first and then row loop,
		//its diagonal traveral with from choosing one column to 
		//ending to fix column but row will increase in asc order
		for(int j = 2; j < n; j++) {
			for(int i = 0; i < n - j; i++) {
				int k = i+j;
				if(isPal[i+1][k-1] && s.charAt(i) == s.charAt(k)) {
					isPal[i][k] = true;
					if(maxLen < k - i + 1) {
						maxLen = k - i + 1;
						start = i;
					}
				}
			}
		}

		return s.substring(start, start + maxLen);
	} 

	public static void main(String[] args) {
		String s = "forgeeksskeegfor";
		System.out.println(longestPdrmSubstr(s));
	}
}