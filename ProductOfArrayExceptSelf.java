import java.util.Arrays;


public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int temp = 1;
        for (int i = nums.length - 1; i>= 0; i--) {
            result[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
}
