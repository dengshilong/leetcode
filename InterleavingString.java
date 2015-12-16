
public class InterleavingString {
	public static boolean isInterleave(String s1, String s2, String s3) {
		int p = s1.length();
		int q = s2.length();
		int r = s3.length();
		if (p + q != r)
			return false;
		boolean[][] dp = new boolean[p + 1][q + 1];
		dp[0][0] = true;
		for (int i = 1; i <= p; i++) {
			dp[i][0] = (dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1));
		}
		for (int j = 1; j <= q; j++) {
			dp[0][j] = (dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1));
		}
		for (int i = 1; i <= p; i++) {
			for (int j = 1; j <= q; j++) {
				if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = true;
				} else if (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = true;
				}
			}
		}
		return dp[p][q];
	}
//	public static boolean isInterleave(String s1, String s2, String s3) {
//		return isInterleave(s1, s2, s3, 0, 0, 0);
//    }
//	private static boolean isInterleave(String s1, String s2, String s3, int i, int j, int k) {
//		if (s3.length() == k)
//			return true;
//		if (s1.length() == i && s2.length() == j)
//			return false;
//		boolean result = false;
//		if (i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
//			result |= isInterleave(s1, s2, s3, i + 1, j, k + 1);
//		}
//		if (j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
//			result |= isInterleave(s1, s2, s3, i, j + 1, k + 1);
//		}
//		return result;
//	}
	public static void main(String[] args) {
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
}
