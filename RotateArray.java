import java.util.Arrays;

public class RotateArray {
	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, nums.length - k , nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}
	public static void reverse(int[] nums, int begin, int end) {
	    while (begin < end) {
	        int temp = nums[begin];
	        nums[begin] = nums[end];
	        nums[end] = temp;
	        begin++;
	        end--;
	    }
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6};
		rotate(nums, 2);
		System.out.println(Arrays.toString(nums));
	}
}
