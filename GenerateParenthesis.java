import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GenerateParenthesis {
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		char[] str = new char[n * 2];
		generateParenthesis(n, n , str, 0, result);
		return result;
	}
	private static void generateParenthesis(int left, int right, char[] str, 
			int length, List<String> result) {
		
		if (length == str.length) {
			result.add(String.valueOf(str));
		} else {
			if (left == right) {
				str[length] = '(';
				generateParenthesis(left - 1, right, str, length + 1, result);
			} else if (left < right) {
				if (left > 0) {
					str[length] = '(';
					generateParenthesis(left - 1, right, str, length + 1, result);
				}
				str[length] = ')';
				generateParenthesis(left, right - 1, str, length + 1, result);
			} 
		}	
	}
//	public static List<String> generateParenthesis(int n) {
//		List<String> result = new ArrayList<String>();
//		generateParenthesis(n, n , n, "", result);
//		return result;
//	}
//	private static void generateParenthesis(int left, int right, int n, 
//			String s, List<String> result) {
//		
//		if (s.length() == n * 2) {
//			result.add(s);
//		} else {
//			if (left == right) {
//				generateParenthesis(left - 1, right, n , s + "(", result);
//			} else if (left < right) {
//				if (left > 0) {
//					generateParenthesis(left - 1, right, n , s + "(", result);
//				}
//				generateParenthesis(left, right - 1, n, s + ")", result);
//			} 
//		}	
//	}
	public static void main(String[] args) {
		List<String> result = generateParenthesis(3);
		for (String s: result) {
			System.out.println(s);
		}
	}
}
