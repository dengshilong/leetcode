
public class WordSearch {
    static int[] stepX = {1, 0, -1, 0};
    static int[] stepY = {0, 1, 0, -1};
    final static int N = 4;
    public static boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {    
                if (_exist(board, visited, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean _exist(char[][] board, boolean[][] visited, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j])
            return false;
        if (board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            index++;
            for (int k = 0; k < N; k++) {
                int x = i + stepX[k];
                int y = j + stepY[k];
                boolean flag = _exist(board, visited, word, index, x, y);
                if (flag) {
                    return true;
                }
            }
            visited[i][j] = false;
        }
        return false;        
    }
//    private static boolean _exist(char[][] board, boolean[][] visited, String word, int index, int i, int j) {
//        if (index == word.length()) {
//            return true;
//        }
//        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j])
//            return false;
//        if (board[i][j] == word.charAt(index)) {
//            visited[i][j] = true;
//            index++;
//            boolean flag = _exist(board, visited, word, index, i + 1, j) ||
//                        _exist(board, visited, word, index, i - 1, j) ||
//                        _exist(board, visited, word, index, i, j + 1) ||
//                        _exist(board, visited, word, index, i, j - 1);
//                
//            if (flag)
//                return true;
//            visited[i][j] = false;
//        }
//        return false;        
//    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }
}
