/** 
* @author: robinjia
* @emai: dpengshilong1988@gmail.com
* @create：2015年12月15日 下午9:05:25 
* 
*/
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) 
            dp[i][0] = i;
        for (int j = 1; j <= word2.length(); j++)
            dp[0][j] = j;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; 
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]);
                }   
            }   
        }   
        int result = dp[word1.length()][word2.length()];
        return result;
    }
    private static int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c); 
    }
    public static void main(String[] args) {
        System.out.println(minDistance("abcd", "bd"));
    }
}
