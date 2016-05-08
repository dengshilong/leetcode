import java.util.Set;


public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i] && wordDict.contains(s.substring(0, i + 1))) {
                dp[i] = true;
            }
            if (dp[i]) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (wordDict.contains(s.substring(i + 1, j + 1))) {
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
    
    public static void main(String[] args) {
        String s = "abcde";
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.substring(0, i + 1));
        }
    }
}
