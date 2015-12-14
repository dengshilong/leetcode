
public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) 
				i++;
			while (j > i && !Character.isLetterOrDigit(s.charAt(j))) 
				j--;
			if (i < j && s.charAt(i) != s.charAt(j)) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
    }
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(""));
		System.out.println(isPalindrome("aa"));
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome("1a2"));
		System.out.println(isPalindrome(".,"));
	}

}
