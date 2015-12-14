
public class FactorialTrailingZeroes {
	public static int trailingZeroes(int n) {
		int count = 0;
	    while (n >= 5) {
	    	int temp = n / 5;
	        count += temp;
	        n = temp;
	    }
	    return count;
    }
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(trailingZeroes(i));
		}
	}
}
