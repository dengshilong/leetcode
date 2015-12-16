
public class MinimumSizeSubarraySum {
	public static int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
        int start = 0;
        int end = 0;
        int sum = nums[start];
        int result = Integer.MAX_VALUE;
        while (end < nums.length) {
        	if (sum >= s) {
        		result = Math.min(result, end - start + 1);
        		sum -= nums[start];
        		start++;
        	} else {
        		end++;
        		if (end < nums.length)
        			sum += nums[end]; 		
        	}
        }
        if (sum >= s) {
    		result = Math.min(result, end - start + 1);
        }
        return result < Integer.MAX_VALUE ? result : 0;
    }
	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, nums));
	}
}
