// Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of horses in the ‘i-th’ stable. There are a ‘m’ number of grooms, and the task is to allocate all the stable to the grooms.
// Allocate stable in such a way that:
// Each groom gets at least one stable.
// Each stable should be allocated to only one groom.
// Stable allocation should be in a contiguous manner.
// You have to allocate the stable to ‘m’ grooms such that the maximum number of horses assigned to a groom is minimum. If the allocation of stable is not possible. return -1
//  Input Format:
// n = 5, m = 4, arr[] = {25, 46, 28, 49, 24}
// Result:71

class GroomTest {
	public static int getMaxHorses(int[] ar, int m) {
		int n = ar.length;
		int res = 0;
		if(m > n) return -1;

		if(m == n) {
			for(int i = 0; i < n; i++) {
				if(res < ar[i])
					res = ar[i];
			}
			return res;
		}

		if(m == 1) {
			for(int i = 0; i < n; i++) {
				res += ar[i];
			}
			return res;
		}

		int window = n - m + 1;

		for(int i = 0; i < window; i++) {
			res += ar[i];
		}

		int windowSum = res;

		for(int i = window; i < n; i++) {
			windowSum = windowSum - ar[i - window] + ar[i];
			if(res > windowSum) {
				res = windowSum;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] ar = {25, 46, 28, 49, 24};
		System.out.println(getMaxHorses(ar, 7));
	}
}