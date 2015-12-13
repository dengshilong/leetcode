
public class Pow {
//	public static double myPow(double x, int n) {
//        if (n == 0) 
//        	return 1;
//        boolean flag = false;
//        if (n < 0) {
//        	n = -n;
//        	flag = true;
//        }
//        double result = 1;
//        if (n % 2 == 1) {
//        	result = x * myPow(x * x, n / 2);
//        } else {
//        	result = myPow(x * x, n / 2);
//        }
//        if (flag) {
//        	result = 1 / result;
//        }
//        return result;
//    }

	public static double myPow(double x, int n) {
        if (n == 0) 
        	return 1;
        boolean flag = false;
        if (n < 0) {
        	n = -n;
        	flag = true;
        }
        double result = 1;
        double p = x;
        while (n > 0) {
        	if (n % 2 == 1) {
        		result *= p;
        	}
        	n >>= 1;
        	p *= p;
        }
        return flag ? 1 / result : result;
    }
    
	public static void main(String[] args) {
		System.out.println(myPow(2.0, 3));
		System.out.println(myPow(2.0, 6));
		System.out.println(myPow(2.0, 5));
		System.out.println(myPow(2.0, -3));
		System.out.println(myPow(0.00001, 2147483647));
	}
}
