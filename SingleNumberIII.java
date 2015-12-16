import java.util.Arrays;


public class SingleNumberIII {
	public static int[] singleNumber(int[] nums) {
		int diff = 0;
	    for (int i: nums) {
	    	 diff ^= i;
	    }
	    diff = Integer.lowestOneBit(diff);
	    int[] result = new int[2];
	    Arrays.fill(result, 0);
	    for (int i: nums) {
	    	if ((i & diff) > 0) {
	    		result[0] ^= i;
	    	} else {
	    		result[1] ^= i;
	    	}
	    }
	    return result;
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 5, 2};
		int[] res = singleNumber(nums);
		for (int i: res) {
			System.out.println(i);
		}
	}
}
