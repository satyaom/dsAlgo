import java.util.*;

class MergeSort {

	public static void merge(int[] ar, int low, int mid, int high) {
		int n1 = mid - low + 1;
		int n2 = high - mid;

		int[] l = new int[n1];
		int[] r = new int[n2];

		for(int it = 0; it < n1; it++) {
			l[it] = ar[it+low];
		}

		for(int it = 0; it < n2; it++) {
			r[it] = ar[it + mid + 1];
		}

		int i = 0, j = 0, k = low;

		while(i < n1 && j < n2) {
			if(l[i] <= r[j]) {
				ar[k] = l[i];
				i++;
			} else {
				ar[k] = r[j];
				j++;
			}
			k++;
		}

		while(i < n1) {
			ar[k] = l[i];
			i++;
			k++;
		}

		while(j < n2) {
			ar[k] = r[j];
			j++;
			k++;
		}
	}

	public static void mergeSort(int[] ar, int low, int high) {
		if(low >= high) return;
		int mid = low + (high - low)/2;
		mergeSort(ar, low, mid);
		mergeSort(ar, mid + 1, high);
		merge(ar, low, mid, high);
	}

	public static void main(String args[]) {
		int[] ar = { 12, 11, 13, 5, 6, 7 };
		mergeSort(ar, 0, ar.length-1);
		System.out.println(Arrays.stream(ar).boxed().toList());
	}
}