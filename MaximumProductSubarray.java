
public class MaximumProductSubarray {
	public static int maxProduct(int[] nums) {
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
       
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] > 0) {
        		max = Math.max(max * nums[i], nums[i]);
        		min = Math.min(min * nums[i], nums[i]);
        	} else {
        		int temp = max;
        		max = Math.max(min * nums[i], nums[i]);
        		min = Math.min(temp * nums[i], nums[i]);
        	}
        	result = Math.max(result, max);
        }
        return result;
    }
	public static void main(String[] args) {
		//int[] nums = {2, 3, -2, 4};
		int[] nums = {7, -2 , -4};
		System.out.println(maxProduct(nums));
	}
}
