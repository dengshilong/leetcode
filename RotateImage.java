import java.util.Arrays;


public class RotateImage {
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
        	for (int j = i; j < n - i - 1; j++) {
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[n - j - 1][i];
        		matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
        		matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
        		matrix[j][n - i - 1] = temp;
        	}
        }
    }
	
	public static void main(String[] args) {
		int n = 3;
		int count = 1;
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = count;
				count++;
			}
		}
		for (int[] m: matrix) {
			System.out.println(Arrays.toString(m));
		}
		rotate(matrix);
		for (int[] m: matrix) {
			System.out.println(Arrays.toString(m));
		}
	}
}
