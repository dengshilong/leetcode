
public class StringToInteger {
    public static int myAtoi(String str) {
        boolean flag = false;
        int i = 0;
        int length = str.length();
        while (i < length && str.charAt(i) == ' ') {
            i++;
        }   
        if (i < length && str.charAt(i) == '+') {
            i++;
        } else if (i < length && str.charAt(i) == '-') {
            flag = true;
            i++;
        }   
        int lastResult = 0;
        int result = 0;
        while (i < length && '0' <= str.charAt(i) && str.charAt(i) <= '9') {
            lastResult = result;
            result = result * 10 + (str.charAt(i) - '0');
            if (lastResult != result / 10) { //overflow
                if (flag) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }   
            }   
            i++;
        }   
        if (flag) {
            result = -result;
        }   
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(myAtoi("-234343"));
        System.out.println(myAtoi("+234"));
        System.out.println(myAtoi("2147483648"));
    }
}
