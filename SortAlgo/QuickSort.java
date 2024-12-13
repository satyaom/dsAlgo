import java.util.*;

class QuickSort {
	public static int partition(int[] ar, int low, int high) {
		int pivot = ar[high];
		int i = low;
		for(int j = low; j <= high-1; j++) {
			if(ar[j] < pivot) {
				int temp = ar[i];
				ar[i] = ar[j];
				ar[j] = temp;
				i++;
			}
		}

		int temp = ar[i];
		ar[i] = ar[high];
		ar[high] = temp;
		return i;
	}

	public static void quickSort(int[] ar, int low, int high) {
		if(low >= high) return;
		int j = partition(ar, low, high);
		quickSort(ar, low, j-1);
		quickSort(ar, j+1, high);
	}

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		quickSort(arr, 0, arr.length -1);
		System.out.println(Arrays.stream(arr).boxed().toList());
	}

}