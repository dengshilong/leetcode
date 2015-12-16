
public class MaximalSquare {
	public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
        	return 0;
        int n = matrix[0].length;
        if (n == 0) {
        	return 0;
        }
        int[][] size = new int[m][n];
        for (int j = 0; j < n; j++) {
        	if (matrix[m - 1][j] == '1') {
        		size[m - 1][j] = 1;
        	} else {
        		size[m - 1][j] = 0;
        	}
        }
        for (int i = 0; i < m; i++) {
        	if (matrix[i][n - 1] == '1') {
        		size[i][n - 1] = 1;
        	} else {
        		size[i][n - 1] = 0;
        	}
        }
        for (int i = m - 2; i >= 0; i--) {
        	for (int j = n - 2; j >= 0; j--) {
        		size[i][j] = (matrix[i][j] == '1') 
        				? (1 + minOfThree(size[i + 1][j], size[i][j + 1], size[i + 1][j + 1]))
        			    : 0;
        	}
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (size[i][j] > result) {
        			result = size[i][j];
        		}
        	}
        }
        return result * result;
    }
	public static int minOfThree(int a, int b, int c) {
		return a <= b ? (a <= c ? a : c) : (b <= c ? b : c);
	}
	public static void main(String[] args) {
		char[][] matrix = {{'1', '1'}, {'1', '1'}};
		int result = maximalSquare(matrix);
		System.out.println(result);
	}
	
}
