
public class DistinctSubsequences {
//	public static int numDistinct(String s, String t) {
//        return numDistinct(s, t, 0, 0);
//    }
//	private static int numDistinct(String s, String t, int i, int j) {
//		if (j == t.length())
//			return 1;
//		if (i == s.length())
//			return 0;
//		int result = 0;
//		for (int k = i; k < s.length(); k++) {
//			if (s.charAt(k) == t.charAt(j)) {
//				result += numDistinct(s, t, k + 1, j + 1);
//			}
//		}
//		return result;
//	}
	public static int numDistinct(String s, String t) {
		int m = t.length();
		int n = s.length();
		int[][] dp = new int[m + 1][n + 1];
		dp[0][0] = 1;
		for (int j = 0; j <= n; j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] += dp[i][j - 1];
				if (t.charAt(i - 1) == s.charAt(j - 1)) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit", "rabit"));
		System.out.println(numDistinct("rabbibit", "rabit"));
		System.out.println(numDistinct("ccc", "c"));
		System.out.println(numDistinct("bcc", "c"));
	}
}
