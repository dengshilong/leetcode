import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static int sumOfSquare(int n) {
		int sum = 0;
		while (n > 0) {
			sum += Math.pow(n % 10, 2);
			n /= 10;
		}
		return sum;
	}
	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		while (n != 1) {
			set.add(n);
			n = sumOfSquare(n);
			if (set.contains(n)) 
				return false;
		}
		return true;
		      
    }
	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}
}
