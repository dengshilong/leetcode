
public class ClimbingStairs {
    public static int climbStairs(int n) {
        int a = 1;
        int b = 1;
        while (n-- > 0) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
