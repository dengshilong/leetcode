
public class SudokuSolver {
	public static void solveSudoku(char[][] board) {
		_dfs(0, board);
    }
	private static boolean _dfs(int n, char[][] board) {
		if (n >= 81)
			return true;
		while (n < 81) {
			int i = n / 9;
			int j = n % 9;
			if (board[i][j] != '.') {
				n++;
			} else {
				for (int k = 1; k <= 9; k++) {
					char ch = (char)(k + '0');
					if (!isValid(board, i, j, ch)) {
						continue;
					} else {
						board[i][j] = ch;
						boolean flag = _dfs(n + 1, board);
						if (flag)
							return true;
						board[i][j] = '.';
					}
				}
				return false;
			}
		}
		return true;
		
	}
	public static boolean isValid(char[][] board, int i, int j, char c) {
		for (int m = 0; m < 9; m++) {
			if (m != j && board[i][m] == c)
				return false;
			if (m != i && board[m][j] == c)
				return false;
		}
		for (int m = i / 3 * 3; m < i / 3 * 3 + 3; m++) {
			for (int n = j / 3 * 3; n < j / 3 * 3 + 3; n++) {
				if (m != i && n != j && board[m][n] == c)
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String[] s = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][] board = new char[9][9];
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length(); j++) {
				board[i][j] = s[i].charAt(j);
			}
		}
		solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println("");
		}
	}
}
