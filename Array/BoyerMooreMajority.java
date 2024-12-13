class BoyerMooreMajority {
	// Majority candidate occurance greater than ArraySize/2
	private static int maxVote(int[] ar) {
		int count = 0, canditate = -1;
		for(int i = 0; i < ar.length; i++) {
			if(count == 0) {
				canditate = ar[i];
				count = 1;
			} else {
				if(ar[i] == canditate) {
					count++;
				} else {
					count--;
				}
			}
		}
		
		int canditateFreq = 0;
		for(int i = 0; i < ar.length; i++) {
			if(canditate == ar[i]) canditateFreq++;
		}

		int majorityFreq = ar.length/2;

		if(canditateFreq > majorityFreq) {
			return canditate;
		}
 
		return -1;
	}

	public static void main(String[] args) {
		int[] ar = {1, 2, 3, 2, 1, 2};
		System.out.println(maxVote(ar));
	}
}