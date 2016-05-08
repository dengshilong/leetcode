
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        String result = "";
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - maxLength - 1, i)) {
                result = s.substring(i - maxLength - 1, i + 1);
                maxLength = maxLength + 2;    
            } else if(isPalindrome(s, i - maxLength, i)) {
                result = s.substring(i - maxLength, i + 1);
                maxLength = maxLength + 1;
                
            }
        }
        return result;
    }
    public static boolean isPalindrome(String s, int i, int j) {
        if (i < 0)
            return false;
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
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("aacdedcbe"));
    }
}
