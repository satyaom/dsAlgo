import java.util.*;
class BubbleSort {
	public static void bubbleSort(int[] ar) {
		for(int i = 0; i < ar.length; i++) {
			for(int j = 0; j < ar.length -1; j++) {
				if(ar[j] > ar[j+1]) {
					int temp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6 };
		bubbleSort(arr);
		System.out.println(Arrays.stream(arr).boxed().toList());
	}
}