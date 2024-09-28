import java.io.*;

class DiagonalTraversal {
	static void diagonalTraversal(int[][] mat, int n) {
		for(int i = n-1; i >= 0; i--) {
			for(int j = 0; j < n - i; j++) {
				System.out.print(mat[i+j][j] + " ");
			}
			System.out.println();
		}

		for(int j = 1; j < n; j++) {
			for(int i = 0; i < n - j; i++) {
				System.out.print(mat[i][j+i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] arr = {
			{1, 2, 3}, 
			{4, 5, 6}, 
			{7, 8, 9}
		};
		diagonalTraversal(arr, 3);
	}
}