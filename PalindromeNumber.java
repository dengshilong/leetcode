
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (0 <= x && x <= 9) {
            return true;
        }   
        if (x < 0 || x % 10 == 0) {
            return false;
        }   
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10; 
            x = x / 10;
        }   
        return (x == y || y / 10 == x);
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(2345432));
        System.out.println(isPalindrome(-23));
    }
}
