
public class SingleNumber {
	public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
        	res ^= nums[i];
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,3,2,5,1};
		System.out.println(singleNumber(nums));
	}
}
