
public class NumberOfOneBits {
	// you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
    	int count = 0;
        while (n > 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
    public static void main(String[] args) {
    	for (int i = 1; i < 10; i++) {
    		System.out.println(hammingWeight(i));
    	}
    }
}
