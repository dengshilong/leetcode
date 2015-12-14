
public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int r = n % 26;
        	n /= 26;
        	if (r == 0) {
        		sb.append('Z');
        		n--;
        	} else {
        		sb.append((char)(r + 'A' - 1));
        	}
		}
        sb.reverse();
        return sb.toString();
    }
	public static void main(String[] args) {
		System.out.println(convertToTitle(26));
		System.out.println(convertToTitle(27));
		System.out.println(convertToTitle(52));
	}
}
