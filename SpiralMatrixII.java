import java.util.Arrays;


public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0)
            return matrix;
        int count = 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++)
                matrix[i][j] = count++;
            for (int j = i; j < n - i - 1; j++)
                matrix[j][n - i - 1] = count++;
            for (int j = n - i - 1; j > i; j--)
                matrix[n - i - 1][j] = count++;
            for (int j = n - i - 1; j > i; j--)
                matrix[j][i] = count++;
        }
        if (matrix[n / 2][n / 2] == 0)
            matrix[n / 2][n / 2] = count;
        return matrix;
    }
//    public static int[][] generateMatrix(int n) {
//        int[][] matrix = new int[n][n];
//        if (n == 0)
//            return matrix;
//        int[] stepX = {0, 1, 0, -1};
//        int[] stepY = {1, 0, -1, 0};
//        int direction = 0;
//        int i = 0;
//        int j = 0;
//        int count = 1;
//        matrix[0][0] = count;
//        while (count < n * n) {
//            int x = i + stepX[direction];
//            int y = j + stepY[direction];
//            
//            if (x >= 0 && x < n && y >= 0 && y < n && matrix[x][y] == 0) {
//                i = x;
//                j = y;
//                count++;
//                matrix[i][j] = count;            
//            } else {
//                direction = (direction + 1 + 4) % 4;
//            }
//            
//        }
//        return matrix;
//    }
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int[] t: matrix) {
            System.out.println(Arrays.toString(t));
        }
    }
}
