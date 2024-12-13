import java.util.*;

class InserstionSort {
	public static void insertionSort(int[] ar) {

		for(int i = 1; i < ar.length; i++) {

			//Insert key to left hand sorted array
			//Right hand of array is unsorted
			int key = ar[i];
			int j = i-1;
			while(j >=0 && ar[j] > key) {
				ar[j+1] = ar[j];
				j--;
			}
			ar[j+1] = key;
		}
	}

	public static void main(String[] args) {
		 int arr[] = { 12, 11, 13, 5, 6 };
		 insertionSort(arr);
		 System.out.println(Arrays.stream(arr).boxed().toList());
	}
}