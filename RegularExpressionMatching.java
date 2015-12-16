
public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		boolean[][] match = new boolean[m + 1][n + 1];
		match[0][0] = true;
		for (int i = 2; i <= n; i = i + 2) {
			if (p.charAt(i - 2) != '*' && p.charAt(i - 1) == '*') {
				match[0][i] = match[0][i - 2];
			}
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1)) {
					match[i][j] = match[i - 1][j - 1];
				} else if(p.charAt(j - 1) == '.' && (j == n || j < n && p.charAt(j) != '*')) {
					match[i][j] = match[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					if (j - 2 >= 0) {
						match[i][j] = match[i][j - 2];
						if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
							match[i][j] |= match[i - 1][j] | match[i - 1][j - 2];
						}
					}
					
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
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch("aab", "a*b"));
		System.out.println(isMatch("", "."));
		System.out.println(isMatch("", "*"));
		System.out.println(isMatch("a", "a*"));
		System.out.println(isMatch("aaa", "ab*a"));
		System.out.println(isMatch("aa", "ab*"));
		System.out.println(isMatch("aa", "c*a*"));
		System.out.println(isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));
		System.out.println(isMatch("aaa", "a.a"));
		System.out.println(isMatch("a", "."));
		System.out.println(isMatch("", "c*c*"));
	}

}
