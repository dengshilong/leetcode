import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WordBreakII {
	public static List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> result = new ArrayList<String>();
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
		if (dp[s.length() -1])
			wordBreak(s, wordDict, 0, result, new ArrayList<String>(), dp);
		return result;
	}
	private static void wordBreak(String s, Set<String> wordDict, int start, 
			List<String> result, List<String> cur, boolean[] dp) {
		if (start == s.length() && cur.size() > 0) {
			int j = 0;
			StringBuilder sb = new StringBuilder();
			sb.append(cur.get(j));
			for (j = 1; j < cur.size(); j++) {
				sb.append(" ");
				sb.append(cur.get(j));
			}
			result.add(sb.toString());
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (!dp[i])
				continue;
			String word = s.substring(start, i + 1);
			if (wordDict.contains(word)) {
				cur.add(word);
				wordBreak(s, wordDict, i + 1, result, cur, dp);
				cur.remove(cur.size() - 1);
			}
		}
	}
	public static void main(String[] args) {
		String[] words = {"cat", "cats", "and", "sand", "dog"};
		Set<String> wordDict = new HashSet<String>();
		for (String word: words) {
			wordDict.add(word);
		}
		List<String> result = wordBreak("catsanddog", wordDict);
		for (String s: result) {
			System.out.println(s);
		}
	}
}
