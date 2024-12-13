import java.util.*;
class MaxProductSubarray {
	public static int maxProduct(int[] ar) {
		int maxProduct = ar[0];
		int minProduct = ar[0];
		int result = ar[0];
		for(int i = 1; i < ar.length; i++) {
			int[] minMaxAr = {ar[i], maxProduct*ar[i], minProduct*ar[i]};
			maxProduct = Arrays.stream(minMaxAr).max().getAsInt();
			minProduct = Arrays.stream(minMaxAr).min().getAsInt();
			if(result < maxProduct)
				result = maxProduct;
		}
		return result;
	}

	public static void main(String
		[] args) {
		int[] ar = {3,-1,4};
		System.out.println(maxProduct(ar));
	}
}

// track negative numbers, if its even then check for multiple, keep multiplying