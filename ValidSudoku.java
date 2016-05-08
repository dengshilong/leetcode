
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (!isValid(board, i, j))
                    return false;    
            }
        }
        return true; 
    }
    private static  boolean isValid(char[][] board, int i, int j) {
        for (int m = 0; m < 9; m++) {
            if (m != j && board[i][m] == board[i][j]) // row
                return false;
            if (m != i && board[m][j] == board[i][j]) // column
                return false;
        }
        for (int m = i / 3 * 3; m < i / 3 * 3 + 3; m++) { // 3 * 3 grid
            for (int n = j / 3 * 3; n < j / 3 * 3 + 3; n++) {
                if (m != i && n != j && board[m][n] == board[i][j])
                    return false;
            }
        }
        return true;
    }
    public static char[][] createBoard(String[] strs) {
        char[][] board = new char[strs.length][strs[0].length()];
        for (int i = 0; i < strs.length; i++) {
            board[i] = strs[i].toCharArray();
        }
        return board;
    }
    public static void main(String[] args) {
        String[] strs = { 
                ".87654321",
                "2........",
                "3........",
                "4........",
                "5........",
                "6........",
                "7........",
                "8........",
                 "9........"};
        char[][] board = createBoard(strs);
        System.out.println(isValidSudoku(board));
    }
}
