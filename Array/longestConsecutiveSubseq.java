import java.io.*;
import java.util.*;

class LongestConsecutiveSubseq {
	static int longestConsqSubsq(int[] ar) {
		Set<Integer> seq = new HashSet<>();
		int n = ar.length;
		int ans = 0;

		// intially add every element to hash
		for(int i = 0; i < ar.length; i++) 
			seq.add(ar[i]);

		for(int i = 0; i < n; i++) {
			//check if starting position of sequence
			if(seq.contains(ar[i] + 1)) {
				int j = ar[i];
				while(seq.contains(j)) {
					System.out.print(j+" ");
					j++;
				}

				if(ans < j - ar[i]) {
					ans = j - ar[i];
				}
			}
		}
		return ans;
	}

	public static void main(String args[]) {
		int[] ar = {1, 9, 3, 10, 4, 20, 2};
		System.out.println(longestConsqSubsq(ar));
	}
}

