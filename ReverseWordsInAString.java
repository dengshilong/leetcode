
public class ReverseWordsInAString {
	public static String reverseWords(String s) {
		s = s.trim();
		String[] words = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		sb.append(words[words.length - 1]);
		for (int i = words.length - 2; i >= 0; i--) {
			sb.append(" ");
			sb.append(words[i]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(reverseWords("the  sky    is blue"));
		System.out.println(reverseWords(""));
	}
}
