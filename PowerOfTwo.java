
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n & (n - 1)) == 0;
    }
    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.println(i + " " + isPowerOfTwo(i));
        }
    }
}
