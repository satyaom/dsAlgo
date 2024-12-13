class BuySell {

	public static int buySell(int[] ar) {
		int maxProfit = 0;
		int smallestPrice = ar[0];
		for(int i = 1; i < ar.length; i++) {
			int profit = ar[i] - smallestPrice;
			if(maxProfit < profit) {
				maxProfit = profit;
			}
			if(smallestPrice > ar[i]) {
				smallestPrice = ar[i];
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] ar = {7, 1, 5, 3, 6, 4};
		System.out.println(buySell(ar));
	}
}