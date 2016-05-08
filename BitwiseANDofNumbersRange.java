
public class BitwiseANDofNumbersRange {
    public static int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return n << i;
    }
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(4, 7));
    }
}
