import java.util.Arrays;

class HeapSort {
	public static void heapify(int[] ar, int n, int i) {

		int left = i * 2 + 1;
		int right = i * 2 + 2;
		int largest = i;

		if(left < n && ar[largest] < ar[left]) {
			largest = left;
		}

		if(right < n && ar[largest] < ar[right]) {
			largest = right;
		}

		if(largest != i) {
			int temp = ar[largest];
			ar[largest] = ar[i];
			ar[i] = temp;
			heapify(ar, n, largest);
		}
	}

	public static void heapSort(int[] ar) {
		for(int i = ar.length/2; i >= 0; i--) {
			heapify(ar, ar.length, i);
		}

		for(int  i = ar.length-1; i > 0; i--) {
			int temp = ar[i];
			ar[i] = ar[0];
			ar[0] = temp;
			heapify(ar, i, 0);
		}
	}
		

	public static void main(String args[]) {
		 int[] arr = {9, 4, 3, 8, 10, 2, 5};
		 heapSort(arr);
		 System.out.println(Arrays.stream(arr).boxed().toList());
	}
}