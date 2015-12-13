
public class UglyNumber {
	public static boolean isUgly(int num) {
		if (num <= 0) 
			return false;
        int a[] = {2, 3, 5};
        for (int i = 0; i < a.length; i++) {
        	while (num % a[i] == 0) {
        		num /= a[i];
        	}
        	if (num == 1) {
        		return true;
        	}
        }
        return false;
    }
	
	public static void main(String[] args) {
		System.out.println(isUgly(5));
		System.out.println(isUgly(1));
		System.out.println(isUgly(14));
		System.out.println(isUgly(0));
	}
}
