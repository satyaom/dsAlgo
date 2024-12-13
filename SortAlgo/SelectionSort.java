import java.util.*;

class SelectionSort {
	public static void selectionSort(int[] ar) {
		for(int i = 0; i < ar.length; i++) {
			int minI = i;

			for(int j = i; j < ar.length; j++) {
				if(ar[j] < ar[minI])
					minI = j;
			}

			int temp = ar[minI];
			ar[minI] = ar[i];
			ar[i] = temp;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6 };
		 selectionSort(arr);
		 System.out.println(Arrays.stream(arr).boxed().toList());
	}
}