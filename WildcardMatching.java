
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*')
                match[0][j] = match[0][j - 1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    match[i][j] = match[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    match[i][j] = match[i - 1][j - 1] | match[i - 1][j] | match[i][j - 1];
                }
            }
        }
        return match[m][n];
    }
    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","aa"));
        System.out.println(isMatch("aaa","aa"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", "?*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("", "?"));
        System.out.println(isMatch("a", "a*"));
    }
}
