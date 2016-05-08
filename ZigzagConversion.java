
public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        if (numRows == 1 || s.length() == 0) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            int step1 = (numRows - i - 1) * 2;
            int step2 = i * 2;
            int pos = i;
            if (pos < length)
                sb.append(s.charAt(pos));
            while (true) {    
                pos += step1;
                if (pos >= length)
                    break;
                if (step1 > 0) {
                    sb.append(s.charAt(pos));
                }
                pos += step2;
                if (pos >= length)
                    break;
                if (step2 > 0) {
                    sb.append(s.charAt(pos));
                }    
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
