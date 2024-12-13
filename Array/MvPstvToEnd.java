import java.util.*;

class MvPstvToEnd {
	public static void move(int[] ar) {
		int i = 0, j = ar.length-1;
		while(i < j) {
			if(ar[i] > 0) {
				int temp = ar[i];
				ar[i] = ar[j];
				ar[j] = temp;
				j--;
			} else {
				i++;
			}
		}
	}

	public static void main(String[] args) {
		int[] ar = {-12, -11, -13, -5, -6, -7, -5, -3, -6};
		move(ar);
		System.out.println(Arrays.stream(ar).boxed().toList());
	}
}