import java.util.Arrays;


public class NQueensII {
    public static int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return totalNQueens(0, n, board);
    }
    //check if queen can put on board[row][col]
    private static boolean canPutCheck(int row, int col, int n, boolean[][] board) {
        for (int i = 0; i < n; i++) {
            if (board[row][i]) //row
                return false;
            if (board[i][col]) //col
                return false;
        }
        //diagonal
        int i = 0;
        while (row + i < n && col + i < n) {
            if (board[row + i][col +i])
                return false;
            i++;
        }
        i = 0;
        while (row - i >= 0 && col - i >= 0) {
            if (board[row - i][col - i])
                return false;
            i++;
        }
        //back diagonal
        i = 0;
        while (row + i < n && col - i >= 0) {
            if (board[row + i][col - i])
                return false;
            i++;
        }
        i = 0;
        while (row - i >= 0 && col + i < n) {
            if (board[row - i][col + i])
                return false;
            i++;
        }
        return true;
        
    }
    private static int totalNQueens(int row, int n, boolean[][] board) {
        if (row == n) { 
            return 1;
        }
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (canPutCheck(row, j, n, board)) {
                board[row][j] = true;
                count += totalNQueens(row + 1, n, board);
                board[row][j] = false; //backtrack
            }
        }
        return count;
        
    }
    public static void main(String[] args) {
        for (int i = 4; i < 10; i++)
            System.out.println(i + " " + totalNQueens(i));
    }
}
