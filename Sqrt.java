
public class Sqrt {
    public static int mySqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
    public static void main(String[] args) {
        //System.out.println(mySqrt(4));
        System.out.println(mySqrt(2147395599));
        //System.out.println(mySqrt(9));
    }
}
