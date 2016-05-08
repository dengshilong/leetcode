import java.util.Arrays;


public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (i == 0) {
                        row = true;
                    }
                    matrix[0][j] = 0;
                    if (j == 0) {
                        col = true;
                    }        
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{0,1,2}};
        for (int[] i: matrix) {
            System.out.println(Arrays.toString(i));
        }
        setZeroes(matrix);
        for (int[] i: matrix) {
            System.out.println(Arrays.toString(i));
        }
        
    }
}
