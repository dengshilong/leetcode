
public class ReverseBits {
	// you need treat n as an unsigned value
    public static int reverseBits(int n) {
    	int res = 0;
    	for (int i = 0; i < 32; i++) {
    		res = (res << 1) | (n & 1);
    		n >>= 1;
    	}
    	return res;
    }
    public static void main(String[] args) {
    	System.out.println(reverseBits(214748364));
    	System.out.println(reverseBits(43261596));
    }
}
