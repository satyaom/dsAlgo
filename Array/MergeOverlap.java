import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlap {
	public static List<int[]> mergeOverlap(int[][] arr) {
		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> res = new ArrayList<>();
		res.add(arr[0]);

		for(int i = 1; i < arr.length; i++) {
			int[] last = res.get(res.size() - 1);
			int[] curr = arr[i];
			if(curr[0] <= last[1]) {
				last[1] = Math.max(last[1], curr[1]);
			} else {
				res.add(curr);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] arr = {{6, 8}, {1, 9}, {2, 4}, {4, 7}};

		List<int[]> res = mergeOverlap(arr);
		for(int[] it: res) {
			System.out.println(it[0] + " " + it[1] + "\n");
		}
	}
}