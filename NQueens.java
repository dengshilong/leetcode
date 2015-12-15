import java.util.ArrayList;
import java.util.List;


public class NQueens {
	public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        boolean[][] board = new boolean[n][n];
        totalNQueens(0, n, board, result);
        return result;
    }
	private static boolean canPutCheck(int row, int col, int n, boolean[][] board) {
		for (int i = 0; i < n; i++) {
			if (board[i][col])
				return false;
			if (board[row][i])
				return false;
		}
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
	private static void totalNQueens(int row, int n, boolean[][] board, List<List<String>> result) {
		if (row == n) {
			List<String> temp = new ArrayList<String>();
			for (int i = 0; i < board.length; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < board.length; j++) {
					if (board[i][j]) {
						sb.append('Q');
					} else {
						sb.append('.');
					}
				}
				temp.add(sb.toString());
			}
			result.add(temp);
			return;
		}
		for (int j = 0; j < n; j++) {
			if (canPutCheck(row, j, n, board)) {
				board[row][j] = true;
				totalNQueens(row + 1, n, board, result);
				board[row][j] = false;
			}
		}
		
	}
	public static void main(String[] args) {
		List<List<String>> result = solveNQueens(8);
		for (int i = 0; i < result.size(); i++) {
			for (String s: result.get(i)) {
				System.out.println(s);
			}
		}
	}
}
