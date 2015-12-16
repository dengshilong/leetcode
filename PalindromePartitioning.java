import java.util.ArrayList;
import java.util.List;


public class PalindromePartitioning {
	 public static List<List<String>> partition(String s) {
	      List<List<String>> result = new ArrayList<List<String>>();
	      if (s.equals(""))
	    	  return result;
	      List<String> cur = new ArrayList<String>();
	      _partition(s, 0, result, cur);
	      return result;
	      
	 }
	 private static void _partition(String s, int start, List<List<String>> result, List<String> cur) {
		 if (start == s.length()) {
			 List<String> temp = new ArrayList<String>(cur);
			 result.add(temp);
			 return;
		 }
		 for (int i = start; i < s.length(); i++) {
	    	  String temp = s.substring(start, i + 1);
	    	  if (isPalindrome(temp)) {
	    		  cur.add(temp);
	    		  _partition(s, i + 1, result, cur);
	    		  cur.remove(cur.size() - 1);
	    	  }
	      }
	 }
	 public static boolean isPalindrome(String s) {
		 if (s.length() <= 1)
			 return true;
		 int i = 0;
		 int j = s.length() - 1;
		 while (i < j) {
			 if (s.charAt(i) != s.charAt(j)) {
				 return false;
			 }
			 i++;
			 j--;
		 }
		 return true;
	 }
	 public static void main(String[] args) {
		 List<List<String>> result = partition("aab");
		 for (List<String> list: result) {
			 for (String s: list) {
				 System.out.print(s + " ");
			 }
			 System.out.println();
		 }
	 }

}
