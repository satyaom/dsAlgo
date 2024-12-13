import java.util.*;

class SearchInRotatedArray {
	public static int searchInRotatedArray(int[] ar, int target) {
		int left = 0, right = ar.length - 1;
		while(left <= right) {
			int mid = left + (right - left)/2;
			if(ar[mid] == target) {
				return mid;
			} else if(ar[mid] >= ar[left]) {
				if(ar[left] <= target && target <= ar[mid]) right = mid - 1;
				else left = mid+1;
			} else if(ar[mid] <= ar[right]) {
				if(ar[mid] <= target && target <= ar[right]) left = mid+1;
				else right = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] ar = {5, 77, 89, 1, 2, 3};
		System.out.println(searchInRotatedArray(ar, 3));
	}
}