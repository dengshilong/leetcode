
public class MaximumSubarray {
//    public static int maxSubArray(int[] nums) {
//        return maxSubArray(nums, 0, nums.length - 1);    
//    }
//    public static int maxSubArray(int[] nums, int left, int right) {
//        if (left > right) {
//            return Integer.MIN_VALUE;
//        } else if (left == right) {
//            return nums[left];
//        } else {
//            int middle = (right - left) / 2 + left;
//            int leftMax = maxSubArray(nums, left, middle);
//            int rightMax = maxSubArray(nums, middle + 1, right);
//            int sum = 0;
//            int maxToLeft = Integer.MIN_VALUE;
//            for (int i = middle; i >= left; i--) {
//                sum += nums[i];
//                maxToLeft = Math.max(maxToLeft, sum);
//            }
//            sum = 0;
//            int maxToRight = Integer.MIN_VALUE;
//            for (int i = middle + 1; i <= right; i++) {
//                sum += nums[i];
//                maxToRight = Math.max(maxToRight, sum);
//            }
//            int result = maxToLeft + maxToRight;
//            result = Math.max(result, leftMax);
//            result = Math.max(result, rightMax);
//            return result;
//        }
//    }
    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            result = Math.max(result, sum);
        }
        return result;      
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, -6, 3, -2, 4, -1, 3, 2, -4};
        System.out.println(maxSubArray(nums));
    }
}
