
public class NumberOfDigitOne {
    public static int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int factor = 1;
        int result = 0;
        while (factor <= n) {
            int high = n / factor / 10;
            int low = n % factor;
            int position = n / factor % 10;
            if (position == 0) {
                result += high * factor;
            } else if (position == 1) {
                result += high * factor + low + 1;
            } else {
                result += (high + 1) * factor;
            }
            if (n / factor < 10)
                break;
            factor *= 10;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(countDigitOne(157));
        System.out.println(countDigitOne(11));
        System.out.println(countDigitOne(22));
        System.out.println(countDigitOne(10));
        System.out.println(countDigitOne(1410065408));
    }
}
