

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {
            int remain = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int temp = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + result[i + j + 1] + remain;
                result[i + j + 1] = temp % 10;
                remain = temp / 10;        
            }
            result[i] = remain;
        }
        StringBuilder sb = new StringBuilder();
        for (int i: result) {
            if (i > 0 || sb.length() > 0) {
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(multiply("34", "32"));
        System.out.println(multiply("34", "0"));
    }
}
